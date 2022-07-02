package coursework;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Investors implements Serializable {
    private ArrayList<Investor> investorsList;

    public Investors() {
        investorsList = new ArrayList<>();
    }
    public ArrayList<Investor> getInvestorsList() {
        return investorsList;
    }
    public void setInvestorsList(ArrayList<Investor> investorsList){
        this.investorsList = investorsList;
    }

    /**
     * Добавить в список инвестора
     * @param investor инвестор
     */
    public void add(Investor investor){
        investorsList.add(investor);
    }

    /**
     * Поменять инвестора в списке по айди
     * @param id порядковый номер инвестора в списке
     * @param investor investor
     */
    public void set(int id, Investor investor){
        investorsList.set(id, investor);
    }

    /**
     * Удалить инвестора из списка по его объекту
     * @param investor инвестор
     */
    public void remove(Investor investor){
        investorsList.remove(investor);
    }

    /**
     * Удаление инвестора из списка по порядковому номеру
     * @param num порядковый номер инвестора в списке
     */
    public void remove(int num) throws IllegalArgumentException {
        if (num < investorsList.size() && num >= 0){
            investorsList.remove(num);
        } else {
            throw new IllegalArgumentException("Некорректный индекс инвестора к удалению");
        }
    }

    @Override
    public String toString() {
        return "Investors{" +
                "investorsList=" + investorsList +
                '}';
    }
}
