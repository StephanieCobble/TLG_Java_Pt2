package gov.irs;

public interface IRS {
    public void collectTaxes();
    public void register(TaxPayer payer);

    // static factory method for the sole IRSEnum.INSTANCE
    public static IRS getInstance() {
        return IRSEnum.INSTANCE;
    }
}