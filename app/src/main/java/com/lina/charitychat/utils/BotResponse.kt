package com.lina.charitychat.utils

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
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //Hello
            message.contains("hello") -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Hello! :)"
                    2 -> "Hello and welcome!"
                    else -> "error" }
            }

            (message.contains("tip") || message.contains("help")) && message.contains("charit") -> {
                return "If you're unsure of what charity to donate to... \n\n- Determine what issues and qualities are important to you in a charity\n- Do research on charities in the areas that you want to make an impact in\n- Consider the needs of the charity and your own needs"
            }

            message.contains("other") && message.contains("donat") -> {
                return "You don't have to just donate to national charities! \nDonate to your local food banks, small but trustworthy organizations, hospitals, etc."
            }

            message.contains("watch out") -> {
                return "Make sure to watch out that:\n- The charity is registered\n- They are transparent with their finances\n- Review their ratings on different charity ratings (such as cents to the cause and demonstrated impacts)"
            }

            message.contains ("helpful") && message.contains("site") -> {
                return "Some helpful charity ranking websites are:\n- List of Charities from CRA\n- charityintelligence.ca\n- charitynavigator.org\n- charitywatch.org"
            }

            message.contains("list") && message.contains("charities") -> {
                return "Here is a list of all the charities in this app:\n\n- A Better World Canada \n- Against Malaria Foundation Canada\n- BC SPCA\n- Big Brothers Big Sisters of Canada\n- CanadaHelps\n- Canadian Breast Cancer Foundation\n- Canadian Feed the Children\n- Canadian Foodgrains Bank\n- Canadian Red Cross"
            }

            message.contains("info") && message.contains("better world") -> {
                return "A Better World Canada\n\nResults Reporting: B+\nDemonstrated Impact: Low\nCents to the Cause: 92%"
            }

            message.contains("info") && message.contains("against malaria") -> {
                return "Against Malaria Foundation Canada\n\nResults Reporting: A\nDemonstrated Impact: High\nCents to the Cause: 100%"
            }

            message.contains("info") && message.contains("spca") -> {
                return "BC SPCA\n\nResults Reporting: A-\nDemonstrated Impact: n/r\nCents to the Cause: 76%"
            }

            message.contains("info") && message.contains("big brothers") -> {
                return "Big Brothers Big Sisters of Canada\n\nResults Reporting: B\nDemonstrated Impact: Average\nCents to the Cause: 86%"
            }

            message.contains("info") && message.contains("canadahelps") -> {
                return "CanadaHelps\n\nResults Reporting: A-\nDemonstrated Impact: n/r\nCents to the Cause: 100%"
            }

            message.contains("info") && message.contains("breast cancer") -> {
                return "Canadian Breast Cancer Foundation\n\nResults Reporting: B+\nDemonstrated Impact: n/r\nCents to the Cause: 47%"
            }

            message.contains("info") && message.contains("feed the children") -> {
                return "Canadian Feed the Children\n\nResults Reporting: A-\nDemonstrated Impact: Good\nCents to the Cause: 54%"
            }

            message.contains("info") && message.contains("foodgrains") -> {
                return "Canadian Foodgrains Bank\n\nResults Reporting: A-\nDemonstrated Impact: High\nCents to the Cause: 85%"
            }

            message.contains("info") && message.contains("red cross") -> {
                return "Canadian Red Cross\n\nResults Reporting: A-\nDemonstrated Impact: Low\nCents to the Cause: 78%"
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            message.contains("source") -> {
                OPEN_CHARITY
            }

            message.contains("donate") && message.contains("better world")-> {
                DONATE_BETTER
            }

            message.contains("donate") && message.contains("malaria")-> {
                DONATE_MALARIA
            }

            message.contains("donate") && message.contains("spca")-> {
                DONATE_SPCA
            }

            message.contains("donate") && message.contains("big brothers")-> {
                DONATE_BROTHERS
            }

            message.contains("donate") && message.contains("canadahelps")-> {
                DONATE_HELPS
            }

            message.contains("donate") && message.contains("cancer")-> {
                DONATE_CANCER
            }

            message.contains("donate") && message.contains("feed the children")-> {
                DONATE_FEED
            }

            message.contains("donate") && message.contains("foodgrains")-> {
                DONATE_GRAINS
            }

            message.contains("donate") && message.contains("red cross")-> {
                DONATE_RED
            }

            message.contains("link") && message.contains("better world")-> {
                INFO_BETTER
            }

            message.contains("link") && message.contains("malaria")-> {
                INFO_MALARIA
            }

            message.contains("link") && message.contains("spca")-> {
                INFO_SPCA
            }

            message.contains("link") && message.contains("big brothers")-> {
                INFO_BROTHERS
            }

            message.contains("link") && message.contains("canadahelps")-> {
                INFO_HELPS
            }

            message.contains("link") && message.contains("cancer")-> {
                INFO_CANCER
            }

            message.contains("link") && message.contains("feed the children")-> {
                INFO_FEED
            }

            message.contains("link") && message.contains("foodgrains")-> {
                INFO_GRAINS
            }

            message.contains("link") && message.contains("red cross")-> {
                INFO_RED
            }


            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I'm sorry, I don't understand :('"
                    1 -> "I don't understand, try asking me in a different way?"
                    2 -> "I'm not sure I understand! Sorry :("
                    else -> "error"
                }
            }
        }
    }
}