package com.agan.boot.modle;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@SuppressWarnings("unchecked")
public class DashboardList {

    private PanelGroupList[]  pgList;

    public static DashboardList createDashboardList() {
//
        PanelGroupList[] pgList = new PanelGroupList[4];
        pgList[0] = new PanelGroupList("New Visits", "0", "784523");
        pgList[1] = new PanelGroupList("Messages", "0", "213423");
        pgList[2] = new PanelGroupList("Purchases", "0", "34523");
        pgList[3] = new PanelGroupList("Shoppings", "0", "52377");
        DashboardList dashboardList = new DashboardList();
        dashboardList.pgList = pgList;
        return dashboardList;
    }
}