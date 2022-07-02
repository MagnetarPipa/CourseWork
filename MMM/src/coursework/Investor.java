package coursework;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Investor implements Serializable {
    private String firstName;
    private String middleName;
    private String lastName;
    private int agreementNumber;
    private String homeAddress;
    private int depositSum;
    boolean autoProlongation;
    private int contractTerm; // в днях

    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAgreementNumber() {
        return agreementNumber;
    }
    public String getHomeAddress() {
        return homeAddress;
    }
    public int getDepositSum() {
        return depositSum;
    }
    public boolean getAutoProlongation() {
        return autoProlongation;
    }
    public int getContractTerm() {
        return contractTerm;
    }

    public Investor(String firstName, String middleName, String lastName, int agreementNumber,
                    String homeAddress, int depositSum, int contractTerm) {
        try {
            this.setFirstName(firstName);
            this.setMiddleName(middleName);
            this.setLastName(lastName);
            this.setAgreementNumber(agreementNumber);
            this.setHomeAddress(homeAddress);
            this.setDepositSum(depositSum);
            this.setAutoProlongation(autoProlongation);
            this.setContractTerm(contractTerm);
        } catch (Exception e) {
            throw new IllegalArgumentException("Поля объекта инвестора не прошли валидацию");
        }
    }
    public Investor(){}

    public void setFirstName(String fullName) throws IllegalArgumentException {
        if (HelperFunctions.checkCapitalLetter(fullName) && fullName.length() < 20) {
            this.firstName = HelperFunctions.cleanDoubleSpaces(fullName);
        } else {
            throw new IllegalArgumentException("Имя инвестора должно начинаться с большой буквы и иметь длину меньше 20 символов");
        }
    }

    public void setMiddleName(String middleName) throws IllegalArgumentException {
        if (HelperFunctions.checkCapitalLetter(middleName) && middleName.length() < 20) {
            this.middleName = HelperFunctions.cleanDoubleSpaces(middleName);
        } else {
            throw new IllegalArgumentException("Отчество инвестора должно начинаться с большой буквы и иметь длину меньше 20 символов");
        }
    }
    public void setLastName(String lastName) throws IllegalArgumentException {
        if (HelperFunctions.checkCapitalLetter(lastName) && lastName.length() < 20) {
            this.lastName = HelperFunctions.cleanDoubleSpaces(lastName);
        } else {
            throw new IllegalArgumentException("Фамилия инвестора должна начинаться с большой буквы и иметь длину меньше 20 символов");
        }
    }

    public void setAgreementNumber(int agreementNumber) throws IllegalArgumentException {
        if (agreementNumber >= 0 && agreementNumber < 30000) {
            this.agreementNumber = agreementNumber;
        } else {
            throw new IllegalArgumentException("Номер договора должен быть между 0 и 30000");
        }
    }

    public void setHomeAddress(String homeAddress) throws IllegalArgumentException {
        if (HelperFunctions.checkCapitalLetter(homeAddress) && homeAddress.length() < 120) {
            this.homeAddress = HelperFunctions.cleanDoubleSpaces(homeAddress);
        } else {
            throw new IllegalArgumentException("Домашний адресс должен начинаться с большой буквы и иметь длину меньше 120 символов");
        }
    }

    public void setDepositSum(int depositSum) throws IllegalArgumentException {
        if (depositSum >= 0 && depositSum < 100000000) {
            this.depositSum = depositSum;
        } else {
            throw new IllegalArgumentException("Сумма депозита должна быть положительным числом до 100 миллионов");
        }
    }

    public void setAutoProlongation(boolean autoProlongation) {
        this.autoProlongation = autoProlongation;
    }

    public void setContractTerm(int contractTerm) throws IllegalArgumentException {
        final int maxContractTerm = 365 * 4; // 4 года
        if (contractTerm > 0 && contractTerm < maxContractTerm) {
            this.contractTerm = contractTerm;
        } else {
            throw new IllegalArgumentException("Срок депозита в днях должен быть больше или равен нулю и меньше 4 лет");
        }
    }

    @Override
    public String toString() {
        return "Investor{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", agreementNumber=" + agreementNumber +
                ", homeAddress='" + homeAddress + '\'' +
                ", depositSum=" + depositSum +
                ", contractTerm=" + contractTerm +
                '}';
    }
}
