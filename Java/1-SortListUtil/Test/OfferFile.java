package com.ouc.cs;

import java.util.List;

public class OfferFile {
	private String inputFileName;     // 输入文件名
	private String outputFileName;    // 输出文件名

	private List<Offer> offerList;    // 出价列表
	
	public OfferFile(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	
	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public List<Offer> getOfferList() {
		return offerList;
	}

	public void setOfferList(List<Offer> offerList) {
		this.offerList = offerList;
	}
	
}
