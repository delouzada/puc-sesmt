/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.factory;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Louzada
 */
public class CriarBanco {
    
    
    public static void main(String[] args) {
//com o banco de dados
Configuration cfg = new AnnotationConfiguration();
cfg.configure("br/com/puc/sesmt/factory/hibernate_mysql.cfg.xml");

SchemaExport se = new SchemaExport(cfg);

se.create(true, true);

}
    
}
