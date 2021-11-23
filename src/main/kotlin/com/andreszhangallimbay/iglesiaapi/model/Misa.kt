package com.andreszhangallimbay.iglesiaapi.model
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "misa")
class Misa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fecha: Date? = null
    var hora: Date? = null
}