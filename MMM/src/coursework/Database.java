package coursework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Database {

    /**
     * Запись всех инвесторов в файл
     * @param investors список всех инвесторов
     * @throws IOException проблемы с доступом к файлу
     */
    public static void WriteToDatabase(ArrayList<Investor> investors) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("database/database.json"), investors);
    }

    /**
     * Загрузить список инвесторов с базы данных в список
     * @return список инвесторов
     * @throws IOException проблемы с доступом к файлу
     */
    public static ArrayList<Investor> LoadFromDatabase() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("database/database.json"), ArrayList.class);
    }
}
