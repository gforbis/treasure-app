package com.gwf.treasure;

public interface EndPoint {
    double fromOriginX();
    double fromOriginY();
    EndPoint move(Direction direction, double distance);
}