package com.javainterviewpoint;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlToJson {
	public static void main(String[] args) {
		String data = "<Bets cust_id=\"4867305\" reserve_id=\"12087174\" amount=\"20.00\">\n"
				+ "<Bet BetID=\"117612267\" BetTypeID=\"1\" BetTypeName=\"Single bets\"\n"
				+ "LineID=\"130579641\" LineTypeID=\"1\" LineTypeName=\"1x2\" RowTypeID=\"1\"\n"
				+ "BranchID=\"1\" BranchName=\"Soccer\" LeagueID=\"9342\" LeagueName=\"TEST\"\n"
				+ "CreationDate=\"2016-05-26T09:37:39.513\" HomeTeam=\"India (IND)\"\n"
				+ "AwayTeam=\"Test YYY\" Stake=\"3.0700\" Odds=\"-110\" Points=\"0.0000\"\n"
				+ "Score=\"0:0\" CommomStatusID=\"14\" Status=\"Opened\" YourBet=\" India (IND)\"\n"
				+ "EventTypeID=\"39\" EventTypeName=\"Live Betting\" TeamMappingID=\"0\" \n"
				+ "LiveScore1=\"0\" LiveScore2=\"0\" EventDate=\"2016-05-26T08:27:10\"\n"
				+ "MasterEventID=\"4499285\" ComboBetNumersLines=\"0\" EventState=\"\"\n"
				+ "EachWaySetting=\"\" EventName=\"India (IND) vs Test YYY\"\n"
				+ "PurchaseBetID=\"117612266\" Gain=\"5.8600\" EventID=\"10167201\" IsFreeBet=\"0\"\n"
				+ "OddsDec=\"1.9091\" UserOddStyle=\"Decimal\"\n"
				+ "ReserveAmountType=\"PartialCashOut\" ReserveAmountTypeID=\"4\"\n"
				+ "OddsInUserStyle=\"1.91\" NumberOfBets=\"1\" Combinations=\"0\"\n"
				+ "OrgStake=\"3.0700\" IsLive=\"1\" WebProviderID=\"0\"\n"
				+ "PartialCashOutOriginalBetID=\"118080070\"/>\n" + "</Bets>";

		try {
			// Create a new XmlMapper to read XML tags
			XmlMapper xmlMapper = new XmlMapper();

			// Reading the XML
			JsonNode jsonNode = xmlMapper.readTree(data.getBytes());

			// Create a new ObjectMapper
			ObjectMapper objectMapper = new ObjectMapper();

			// Get JSON as a string
			String value = objectMapper.writeValueAsString(jsonNode);
			JsonNode rootNode = objectMapper.readTree(value);
			JsonNode betNode = rootNode.path("Bet");
			System.err.println(betNode.path("ReserveAmountType"));
			System.err.println(betNode.path("ReserveAmountTypeID"));

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}