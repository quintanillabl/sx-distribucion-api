package sx.distribucionx

import sx.security.User

class Surtido {

    String id

    String origen

    String tipo

    String nombre

    String comentario

    Boolean	entregaLocal = true

    Boolean	parcial	 = false

    Long documento = 0

    String tipoDeVenta

    Date fecha

    Long folioFac = 0

    User facturo

    String clasificacionVale

    User asignado

    Date inicio

    User cerro

    Date cerrado

    User reviso

    Date revisado

    User entrego

    Date entregado

    User depuro

    Date depurado

    User cancelo

    Date cancelado

    User cortador

    Date asignadoCorte

    Date corteInicio

    Date corteFin

    BigDecimal kilos = 0

    Integer	prods = 0

    BigDecimal tiempoSurtido = 0

    BigDecimal kilosCorte = 0

    Integer	prodsCorte = 0

    BigDecimal tiempoCorte = 0

    String estado


    List cortes =[]

    List auxiliares= []


    static hasMany = [cortes:Corte,auxiliares :AuxiliarSurtido]


    static constraints = {

        comentario nullable: true
        asignado nullable: true
        inicio nullable: true
        corteFin nullable: true
        corteInicio nullable: true
        asignadoCorte nullable: true
        cerro   nullable: true
        cerrado nullable: true
        reviso nullable: true
        revisado nullable: true
        entrego nullable: true
        entregado nullable: true
        depuro nullable: true
        depurado nullable: true
        tiempoSurtido nullable: true
        kilosCorte nullable: true
        prodsCorte nullable: true
        cortador nullable: true
        tiempoCorte nullable: true
        tipo inList:['PST','FAC','SOL','TRS']
        cancelado nullable: true
        cancelo nullable: true
        cortes nullable: true
        auxiliares nullable: true

    }

    static mapping = {
        id generator: 'uuid'
        auxiliares cascade: "all-delete-orphan"
        cortes cascade: "all-delete-orphan"
    }

}
