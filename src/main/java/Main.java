import java.util.ArrayList;

import org.oweis.Lear_API.model.*;
import org.oweis.Lear_API.service.*;

public class MAIN {

	public MAIN() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		SpliceService spliceService = new SpliceService();
		ArrayList<Splice> splices = spliceService.getAllSplicesByIdPartNumber(1,1);
		for(Splice splice : splices) {
			String nameSplice = splice.getNameSplice();
				System.out.println(nameSplice);
				}
			}
	
	}


