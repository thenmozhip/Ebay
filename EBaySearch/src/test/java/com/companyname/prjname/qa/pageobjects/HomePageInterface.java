package com.companyname.prjname.qa.pageobjects;

public interface HomePageInterface {

    String searchText = "#gh-ac";
    String searchBtn = "#gh-btn";

    String allListingsBtn = ".asp.pnl.left .small.sel.tgl_button.first_b";
    String auctionBtn = ".asp.pnl.left .small.cbx.btn.btn-s.btn-ter.tab.tgl_button.center_b";
    String buyItNowBtn = ".asp.pnl.left .small.cbx.btn.btn-s.btn-ter.tab.tgl_button.last_b";

    String firstResultAllListingsTab = "#ResultSetItems li[r='1']";
    String firstResultAllListingsTabPrice = "#ResultSetItems li[r='1'] .lvprice.prc span";
    String firstResultAllListingsTabBids = "#ResultSetItems li[r='1'] .lvformat span";
    String firstResultAllListingsTabPostage = "#ResultSetItems li[r='1'] .lvshipping .bfsp";

    String firstResultBuyItNowTabBuyItNowOption = "#ResultSetItems li[r='1'] .lvformat .logoBin";
    String firstResultBuyItNowTabPrice = "#ResultSetItems li[r='1'] .lvprice.prc span";
    String firstResultBuyItNowPostage =  "#ResultSetItems li[r='1'] .lvshipping .bfsp";

    String pageNumbers = ".pages";
    String pageTwo = "a.pg";
}
