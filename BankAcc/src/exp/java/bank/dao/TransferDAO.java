package exp.java.bank.dao;

public interface TransferDAO {
	public void amountTransfer(Integer myAccountNumber, Integer yourAccountNumber, Double amount);
}
