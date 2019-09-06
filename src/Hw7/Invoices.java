package Hw7;

import java.sql.Date;
import java.text.NumberFormat;

public class Invoices {
    private String emailAddress;
    private String invoiceNumber;
    private Date invoiceDate;
    private double invoiceTotal;

    public Invoices(String emailAddress, String invoiceNumber, Date invoiceDate, double invoiceTotal) {
        this.emailAddress = emailAddress;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceTotal = invoiceTotal;
    }

    public String getEmailAddress() {
        return emailAddress;
    }


    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public String getFormattedInvoiceTotal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(invoiceTotal);
    }

}

