package commonViewModels.home;

import java.sql.Date;

public class dataColumnsViewModels {

	/**
	 * 欄位名稱
	 */
	public String ColumnsName;

	/**
	 * 欄位資料
	 */
	public Object ColumnsValues;

	public dataColumnsViewModels(String columnsName, Object columnsValues) {
		this.ColumnsName = columnsName;
		this.ColumnsValues = columnsValues;
	}
	
	public dataColumnsViewModels(String columnsName, String columnsValues) {
		this.ColumnsName = columnsName;
		this.ColumnsValues = columnsValues;
	}
	
	public dataColumnsViewModels(String columnsName, int columnsValues) {
		this.ColumnsName = columnsName;
		this.ColumnsValues = columnsValues;
	}
	
	public dataColumnsViewModels(String columnsName, boolean columnsValues) {
		this.ColumnsName = columnsName;
		this.ColumnsValues = columnsValues;
	}
	
	public dataColumnsViewModels(String columnsName, Date columnsValues) {
		this.ColumnsName = columnsName;
		this.ColumnsValues = columnsValues;
	}
}
