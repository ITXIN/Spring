package com.agan.boot.modle;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@SuppressWarnings("unchecked")
public class PanelGroupList {
    private String type;
    private String startVal;
    private String endVal;

    PanelGroupList(String type, String startVal, String endVal) {
        this.type = type;
        this.startVal = startVal;
        this.endVal = endVal;
    }
}

