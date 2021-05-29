package com.lina.charitychat.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lina.charitychat.ListActivity
import com.lina.charitychat.R
import com.lina.charitychat.data.Message
import com.lina.charitychat.utils.BotResponse
import com.lina.charitychat.utils.Constants.DONATE_BETTER
import com.lina.charitychat.utils.Constants.DONATE_BROTHERS
import com.lina.charitychat.utils.Constants.DONATE_CANCER
import com.lina.charitychat.utils.Constants.DONATE_FEED
import com.lina.charitychat.utils.Constants.DONATE_GRAINS
import com.lina.charitychat.utils.Constants.DONATE_HELPS
import com.lina.charitychat.utils.Constants.DONATE_MALARIA
import com.lina.charitychat.utils.Constants.DONATE_RED
import com.lina.charitychat.utils.Constants.DONATE_SPCA
import com.lina.charitychat.utils.Constants.INFO_BETTER
import com.lina.charitychat.utils.Constants.INFO_BROTHERS
import com.lina.charitychat.utils.Constants.INFO_CANCER
import com.lina.charitychat.utils.Constants.INFO_FEED
import com.lina.charitychat.utils.Constants.INFO_GRAINS
import com.lina.charitychat.utils.Constants.INFO_HELPS
import com.lina.charitychat.utils.Constants.INFO_MALARIA
import com.lina.charitychat.utils.Constants.INFO_RED
import com.lina.charitychat.utils.Constants.INFO_SPCA
import com.lina.charitychat.utils.Constants.OPEN_CHARITY
import com.lina.charitychat.utils.Constants.OPEN_GOOGLE
import com.lina.charitychat.utils.Constants.OPEN_SEARCH
import com.lina.charitychat.utils.Constants.RECEIVE_ID
import com.lina.charitychat.utils.Constants.SEND_ID
import com.lina.charitychat.utils.Time
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    var messagesList = mutableListOf<Message>()

    private lateinit var adapter: MessagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView()

        clickEvents()

        val random = (0..3).random()
        customBotMessage("Hello! Welcome to Charity Chat!\nSome commands you can ask me:\n\n- list of charities: Shows all charities in the database\n- 'info [charity]': Basic information on the charity \n- 'link [charity]': Brings you to the charity's page on charityintelligence.ca\n- 'donate [charity]: Brings you to the donation page for the charity\n- 'source': Brings you to charityintelligence.ca\n- Ask for tips and help when donating!")

        val button = findViewById<Button>(R.id.charitylist)
        button.setOnClickListener{
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clickEvents() {

        //Send a message
        btn_send.setOnClickListener {
            sendMessage()
        }

        //Scroll back to correct position when user clicks on text view
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun recyclerView() {
        adapter = MessagingAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun onStart() {
        super.onStart()
        //In case there are messages, scroll to bottom when re-opening app
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun sendMessage() {
        val message = et_message.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            messagesList.add(Message(message, SEND_ID, timeStamp))
            et_message.setText("")

            adapter.insertMessage(Message(message, SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }

    private fun botResponse(message: String) {
        val timeStamp = Time.timeStamp()

        GlobalScope.launch {
            //Fake response delay
            delay(1000)

            withContext(Dispatchers.Main) {
                //Gets the response
                val response = BotResponse.basicResponses(message)

                //Adds it to our local list
                messagesList.add(Message(response, RECEIVE_ID, timeStamp))

                //Inserts our message into the adapter
                adapter.insertMessage(Message(response, RECEIVE_ID, timeStamp))

                //Scrolls us to the position of the latest message
                rv_messages.scrollToPosition(adapter.itemCount - 1)

                //Starts Google
                when (response) {
                    OPEN_GOOGLE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    OPEN_SEARCH -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = message.substringAfterLast("search")
                        site.data = Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        startActivity(site)
                    }

                    OPEN_CHARITY-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.charityintelligence.ca/")
                        startActivity(site)
                    }

                    DONATE_BETTER-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.abwcanada.ca/donate/")
                        startActivity(site)
                    }

                    DONATE_MALARIA-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.againstmalaria.com/Donation.aspx")
                        startActivity(site)
                    }

                    DONATE_SPCA-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://spca.bc.ca/donations/make-a-donation/?utm_source=header&utm_campaign=donate")
                        startActivity(site)
                    }

                    DONATE_BROTHERS-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://bigbrothersbigsisters.ca/donate-online/")
                        startActivity(site)
                    }

                    DONATE_HELPS-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.canadahelps.org/en/donate/")
                        startActivity(site)
                    }

                    DONATE_CANCER-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://support.cancer.ca/site/SPageServer?pagename=DJ_NW_donation_type_selector&s_locale=en_CA#_ga=2.17015473.984794415.1622060902-484099664.1622060902")
                        startActivity(site)
                    }

                    DONATE_FEED-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://donate.canadianfeedthechildren.ca/single.php?utm_medium=(none)&utm_source=(direct)&utm_campaign=(not%20set)&_ga=2.249412800.653611236.1622061488-1553243346.1622061488")
                        startActivity(site)
                    }

                    DONATE_GRAINS-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://donate.foodgrainsbank.ca/select-appeal")
                        startActivity(site)
                    }

                    DONATE_RED-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.redcross.ca/donate/appeal/donate-to-the-canadian-red-cross-fund#a0650cb6-ce29-4c40-b663-e749a0a9163f")
                        startActivity(site)
                    }

                    INFO_BETTER-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.charityintelligence.ca/charity-details/967-a-better-world-canada")
                        startActivity(site)
                    }

                    INFO_MALARIA-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.charityintelligence.ca/charity-details/908-against-malaria-foundation-canada")
                        startActivity(site)
                    }

                    INFO_SPCA-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.charityintelligence.ca/charity-details/10-bc-spca")
                        startActivity(site)
                    }

                    INFO_BROTHERS-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.charityintelligence.ca/charity-details/219-big-brothers-big-sisters-of-canada")
                        startActivity(site)
                    }

                    INFO_HELPS-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.charityintelligence.ca/charity-details/902-canadahelps")
                        startActivity(site)
                    }

                    INFO_CANCER-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.charityintelligence.ca/charity-details/21-canadian-breast-cancer-foundation")
                        startActivity(site)
                    }

                    INFO_FEED-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.charityintelligence.ca/charity-details/73-canadian-feed-the-children")
                        startActivity(site)
                    }

                    INFO_GRAINS-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.charityintelligence.ca/charity-details/620-canadian-foodgrains-bank")
                        startActivity(site)
                    }

                    INFO_RED-> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.charityintelligence.ca/charity-details/71-canadian-red-cross")
                        startActivity(site)
                    }

                }
            }
        }
    }

    private fun customBotMessage(message: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Time.timeStamp()
                messagesList.add(Message(message, RECEIVE_ID, timeStamp))
                adapter.insertMessage(Message(message, RECEIVE_ID, timeStamp))

                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}