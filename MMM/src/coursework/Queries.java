package coursework;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class Queries {
    /**
     * Получить строку с инвесторами с базы данных
     * @return строка содержащая инвесторов / неуспешно отправлен запрос
     * @throws IOException
     */
    public static String show() throws IOException {
        try {
            return new BufferedReader(new FileReader(new File("database/database.json"))).readLine();
        } catch (IOException e) {
            System.out.println("Не удается подключиться к базе данных");
        }
        return "{\"showed_successfully\": false}";
    }

    /**
     * Добавить нового инвестора в базу данных
     * @param investorJSON
     * @return статус добавления
     * @throws IOException
     */
    public static String add(String investorJSON) throws IOException, IllegalArgumentException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Investor investor = objectMapper.readValue(investorJSON, Investor.class);
            Main.getInvestors().add(investor);
            Database.WriteToDatabase(Main.getInvestors().getInvestorsList());
            return "{\"added_successfully\": true}";
        } catch (Exception e) {
            System.out.println("Введены неправильные данные инвестора");
            return "{\"added_successfully\": false}";
        }
    }

    public static String edit(String investorJSON) throws IOException, IllegalArgumentException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode investorJsonNode = objectMapper.readTree(investorJSON);
            int id = Integer.parseInt(investorJsonNode.get("id").asText());
            Investor investor = objectMapper.treeToValue(investorJsonNode.get("investor"), Investor.class);
            Main.getInvestors().set(id, investor);
            Database.WriteToDatabase(Main.getInvestors().getInvestorsList());
            return "{\"edited_successfully\": true}";
        } catch (Exception e) {
            System.out.println("Введены неправильные данные инвестора при попытке редактирования");
            return "{\"added_successfully\": false}";
        }
    }

    public static String delete(String ListJSON) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Main.getInvestors().setInvestorsList(objectMapper.readValue(ListJSON, ArrayList.class));
            Database.WriteToDatabase(Main.getInvestors().getInvestorsList());
            return "{\"deleted_successfully\": true}";
        } catch (IOException e) {
            System.out.println("Не удается подключиться к базе данных");
            return "{\"deleted_successfully\": false}";
        }
    }
}
