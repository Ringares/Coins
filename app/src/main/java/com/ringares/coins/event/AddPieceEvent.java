package com.ringares.coins.event;

/**
 * Created by ls
 * on 2015/7/22
 * Description
 */
public class AddPieceEvent {
    private String msg;

    public AddPieceEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
}
