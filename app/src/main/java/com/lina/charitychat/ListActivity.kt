package com.lina.charitychat

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val abetterworldcanadainfo = findViewById<Button>(R.id.abetterworldcanadainfo)
        abetterworldcanadainfo.setOnClickListener{
            val url = "https://www.charityintelligence.ca/charity-details/967-a-better-world-canada"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val abetterworldcanadadonate = findViewById<Button>(R.id.abetterworldcanadadonate)
        abetterworldcanadadonate.setOnClickListener{
            val url = "https://www.abwcanada.ca/donate/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val againstinfo = findViewById<Button>(R.id.againstmalariafoundationcanadainfo)
        againstinfo.setOnClickListener{
            val url = "https://www.charityintelligence.ca/charity-details/908-against-malaria-foundation-canada"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val againstdonate = findViewById<Button>(R.id.againstmalariafoundationcanadadonate)
        againstdonate.setOnClickListener{
            val url = "https://www.againstmalaria.com/Donation.aspx"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val bcspcainfo = findViewById<Button>(R.id.bcspcainfo)
        bcspcainfo.setOnClickListener{
            val url = "https://www.charityintelligence.ca/charity-details/10-bc-spca"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val bcspcadonate = findViewById<Button>(R.id.bcspcadonate)
        bcspcadonate.setOnClickListener{
            val url = "https://spca.bc.ca/donations/make-a-donation/?utm_source=header&utm_campaign=donate"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val bigbrotherinfo = findViewById<Button>(R.id.bigbrothersbigsistersofcanadainfo)
        bigbrotherinfo.setOnClickListener{
            val url = "https://www.charityintelligence.ca/charity-details/219-big-brothers-big-sisters-of-canada"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val bigbrotherdonate = findViewById<Button>(R.id.bigbrothersbigsistersofcanadadonate)
        bigbrotherdonate.setOnClickListener{
            val url = "https://bigbrothersbigsisters.ca/donate-online/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }


        val canadahelpsinfo = findViewById<Button>(R.id.canadahelpsinfo)
        canadahelpsinfo.setOnClickListener{
            val url = "https://www.charityintelligence.ca/charity-details/902-canadahelps"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val canadahelpsdonate = findViewById<Button>(R.id.canadahelpsdonate)
        canadahelpsdonate.setOnClickListener{
            val url = "https://www.canadahelps.org/en/donate/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val canadianbreastcancerinfo = findViewById<Button>(R.id.canadianbreastcancerfoundationinfo)
        canadianbreastcancerinfo.setOnClickListener{
            val url = "https://www.charityintelligence.ca/charity-details/21-canadian-breast-cancer-foundation"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val canadianbreastcancerdonate = findViewById<Button>(R.id.canadianbreastcancerfoundationdonate)
        canadianbreastcancerdonate.setOnClickListener{
            val url = "https://support.cancer.ca/site/SPageServer?pagename=DJ_NW_donation_type_selector&s_locale=en_CA#_ga=2.17015473.984794415.1622060902-484099664.1622060902"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val canadianfeedinfo = findViewById<Button>(R.id.canadianfeedthechildreninfo)
        canadianfeedinfo.setOnClickListener{
            val url = "https://www.charityintelligence.ca/charity-details/73-canadian-feed-the-children"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val canadianfeeddonate = findViewById<Button>(R.id.canadianfeedthechildrendonate)
        canadianfeeddonate.setOnClickListener{
            val url = "https://donate.canadianfeedthechildren.ca/single.php?utm_medium=(none)&utm_source=(direct)&utm_campaign=(not%20set)&_ga=2.249412800.653611236.1622061488-1553243346.1622061488"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val foodgrainsinfo = findViewById<Button>(R.id.canadianfoodgrainsbankinfo)
        foodgrainsinfo.setOnClickListener{
            val url = "https://www.charityintelligence.ca/charity-details/620-canadian-foodgrains-bank"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val foodgrainsdonate = findViewById<Button>(R.id.canadianfoodgrainsbankdonate)
        foodgrainsdonate.setOnClickListener{
            val url = "https://donate.foodgrainsbank.ca/select-appeal"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val canadianredcrossinfo = findViewById<Button>(R.id.canadianredcrossinfo)
        canadianredcrossinfo.setOnClickListener{
            val url = "https://www.charityintelligence.ca/charity-details/71-canadian-red-cross"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val canadianredcrossdonate = findViewById<Button>(R.id.canadianredcrossdonate)
        canadianredcrossdonate.setOnClickListener{
            val url = "https://www.redcross.ca/donate/appeal/donate-to-the-canadian-red-cross-fund#a0650cb6-ce29-4c40-b663-e749a0a9163f"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        val button = findViewById<Button>(R.id.charitylistback)
        button.setOnClickListener{
            finish();
        }
    }
}