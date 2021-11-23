package com.andreszhangallimbay.iglesiaapi.model

import javax.persistence.*

@Entity
@Table(name = "iglesia")
class Iglesia {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(updatable = false)
  var id: Long? = null
  var nombre: String? = null
  var color: String? = null
  var direccion: String? = null

}
