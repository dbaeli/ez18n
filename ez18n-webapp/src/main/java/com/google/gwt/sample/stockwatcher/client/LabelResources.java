package com.google.gwt.sample.stockwatcher.client;

import org.ez18n.Message;
import org.ez18n.MessageBundle;

@MessageBundle
public interface LabelResources {

    @Message(value = "Stock symbol", mobile = "Sym")
    String symbol();

    @Message(value = "Stock price", mobile = "Price")
    String price();

    @Message(value = "Change")
    String change();

    @Message(value = "Remove", mobile = "Del")
    String remove();

    @Message(value = "Last update : {0}", mobile = "Update : {0}")
    String lastUpdate(String date);

    @Message(value = "Add symbol", mobile = "Add")
    String add();
    
    @Message(value = "{0,number,+#,##0.00;-#,##0.00} ({1,number,+#,##0.00;-#,##0.00} %)", mobile = "{0,number,+#,#0.0;-#,#0.0} ({1,number,+#,#0.0;-#,#0.0} %)")
    String changeValue(double value, double percent);
    
    @Message(value = "{0,number,#,##0.00}", mobile = "{0,number,#,#0.0}")
    String priceValue(double value);
    
    @Message(value = "watchListNumericColumn", mobile = "watchListNumericColumnMobile")
    String styleWatchListNumericColumn();
    
    @Message(value = "watchListRemoveColumn", mobile = "watchListRemoveColumnMobile")
    String styleWatchListRemoveColumn();
    
    @Message(value = "watchListHeader", mobile = "watchListHeaderMobile")
    String styleWatchListHeader();
    
    @Message(value = "watchList", mobile = "watchListMobile")
    String styleWatchList();
}
