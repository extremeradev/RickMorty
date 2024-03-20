package com.app.rickmorty.model;

import java.util.List;

public class ResponseModel {

    private InfoModel info;
    private List<CharacterModel> results;


    public ResponseModel(InfoModel info, List<CharacterModel> results) {
        this.info = info;
        this.results = results;
    }

    public InfoModel getInfo() {
        return info;
    }

    public void setInfo(InfoModel info) {
        this.info = info;
    }

    public List<CharacterModel> getResults() {
        return results;
    }

    public void setResults(List<CharacterModel> results) {
        this.results = results;
    }

}
