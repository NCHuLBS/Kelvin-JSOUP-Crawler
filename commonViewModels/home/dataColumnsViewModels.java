package commonViewModels.home;

import java.sql.Date;

public class dataColumnsViewModels {

	/**
	 * ���W��
	 */
	public String ColumnsName;

	/**
	 * �����
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
