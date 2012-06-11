package com.google.gwt.sample.stockwatcher.client;

import org.ez18n.apt.Label;
import org.ez18n.apt.LabelBundle;

@LabelBundle
public interface LabelResources {

    @Label(value = "Stock symbol", mobile = "Sym")
    String symbol();

    @Label(value = "Stock price", mobile = "Price")
    String price();

    @Label(value = "Change", mobile = "Change")
    String change();

    @Label(value = "Remove", mobile = "Del")
    String remove();

    @Label(value = "Last update : {0}", mobile = "Update : {0}")
    String lastUpdate(String date);

    @Label(value = "Add symbol", mobile = "Add")
    String add();
    
    @Label(value = "{0,number,+#,##0.00;-#,##0.00} ({1,number,+#,##0.00;-#,##0.00} %)", mobile = "{0,number,+#,#0.0;-#,#0.0} ({1,number,+#,#0.0;-#,#0.0} %)")
    String changeValue(double value, double percent);
    
    @Label(value = "{0,number,#,##0.00}", mobile = "{0,number,#,#0.0}")
    String priceValue(double value);
    
    @Label(value = "watchListNumericColumn", mobile = "watchListNumericColumnMobile")
    String styleWatchListNumericColumn();
    
    @Label(value = "watchListRemoveColumn", mobile = "watchListRemoveColumnMobile")
    String styleWatchListRemoveColumn();
    
    @Label(value = "watchListHeader", mobile = "watchListHeaderMobile")
    String styleWatchListHeader();
    
    @Label(value = "watchList", mobile = "watchListMobile")
    String styleWatchList();
}
