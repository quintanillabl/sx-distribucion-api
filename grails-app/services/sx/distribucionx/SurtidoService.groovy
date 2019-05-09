package sx.distribucionx

import grails.gorm.transactions.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import groovy.sql.Sql


@Transactional
class SurtidoService {

      @Autowired
    @Qualifier('dataSource')
    def dataSource

     def sql

    def serviceMethod() {

    }

    def getFacturas(){
        println "Obteniendo Facturas"
        sql  = new Sql(dataSource)
        def facturas = sql.rows("select * from venta where cuenta_por_cobrar_id is not null and puesto is null and surtido is false")
        return facturas
    }

    def getPedidos(){
        println "Obteniendo Pedidos"
         sql = new Sql(dataSource)
        def facturas = sql.rows("select * from venta where cuenta_por_cobrar_id is  null and puesto is not null and surtido is false")
        return facturas
    }

    def iniciarSurtidoFactura(String id, String tipo){
        sql = new Sql(dataSource)
        def query = "select * from venta where id=?"
        def queryPartidas = "select * from venta_det where venta_id = ?"
        def maestro = sql.firstRow(query,[id])
        def detalles = sql.rows(queryPartidas,[id])
        println "Maestro: "+maestro.id
        detalles.each{detalle ->
            println "Detalle: "+detalle
        }
    }
}