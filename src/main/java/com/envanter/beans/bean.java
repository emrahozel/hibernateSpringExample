package com.envanter.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.envanter.repository.envanterRepository;
import com.envanter.model.envanterModel;

/**
 * Created by emrahozel on 13.09.2017.
 */
@ManagedBean
@ViewScoped
public class bean extends SpringBeanAutowiringSupport implements Serializable{

    private List<envanterModel> envanterList = new ArrayList<>();
    private envanterModel article = new envanterModel();
    private envanterModel select;

    @Autowired
    private envanterRepository repository;

    public void save(){
        repository.save(article);
        article = new envanterModel();
    }
    public void delete(){
        repository.delete(article);
    }
    public void update(){
        repository.saveAndFlush(article);
    }
    public void selectEvent(){
        article = select;
    }

    public List<envanterModel> getEnvanterList() {
        envanterList = repository.findAll();
        return envanterList;
    }

    public void setEnvanterList(List<envanterModel> envanterList) {
        this.envanterList = envanterList;
    }

    public envanterModel getArticle() {
        return article;
    }

    public void setArticle(envanterModel article) {
        this.article = article;
    }

    public envanterModel getSelect() {
        return select;
    }

    public void setSelect(envanterModel select) {
        this.select = select;
    }
}
