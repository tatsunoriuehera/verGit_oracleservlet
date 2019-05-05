package study.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ImportInfo implements Serializable {

	public ImportInfo() {
	}
	private String code;
	private String countries;
	private String symbol;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountries() {
		return this.countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
