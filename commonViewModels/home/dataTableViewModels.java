package commonViewModels.home;

import java.util.ArrayList;

public class dataTableViewModels {

	public ArrayList<dataRowsViewModels> DataRows;
	
	public dataTableViewModels(ArrayList<dataRowsViewModels> dataRows){
		this.DataRows = dataRows;
	}
	
	public int GetRowsCount(){
		return this.DataRows.size();
	}
}


