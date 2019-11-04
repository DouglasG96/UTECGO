package com.jorge.utecgo.modules;

import java.util.List;

/**
 * Created by jorge on 17/11/2017.
 */

public interface DirectionFinderListener {

    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);

}
