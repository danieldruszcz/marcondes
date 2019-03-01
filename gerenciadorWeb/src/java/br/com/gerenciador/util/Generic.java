/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.util;

/**
 *
 * @author danieldruszcz
 */
public class Generic<T>
{
    private Class<T> clazz;

    public Generic(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    public T buildOne() throws InstantiationException,
        IllegalAccessException
    {
        return clazz.newInstance();
    }
}
