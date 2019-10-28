<template>
    <div>
      <b-modal id="modal-1" title="CAMBIAR CONTRASEÑA" hide-footer>
        <cambioMiPass></cambioMiPass>
      </b-modal>      
        <header-page :items = "items"></header-page>
    <b-card no-body>
    <b-tabs  card vertical>
      <b-tab title="Entrenar Bot" active :title-item-class="'tab-title-class-left'">
        <b-card-text>
        <masterEntrenador></masterEntrenador>  
        </b-card-text>
      </b-tab>
      <b-tab title="Cambiar Mi Contraseña" @click="$bvModal.show('modal-1')" :title-item-class="'tab-title-class-left'">        
      </b-tab>
      <b-tab title="Salir del Sistema" :title-item-class="'tab-title-class-left'" @click="salir">
        <b-card-text>Salir del Sistema</b-card-text>
      </b-tab> 
    </b-tabs>
  </b-card>
</div>
</template>
<script>

import cambioMiPass from "../03-Generico/cambioContrasena.vue"
import headerPage from "../03-Generico/headerPage.vue"
import masterEntrenador from '../05-Entrenador/masterEntrenador.vue'
export default {
    components:{
        cambioMiPass,
        headerPage,
        masterEntrenador
    },
    methods:{
      salir(){
          this.$router.push('/');
      }
    },
    data() {
      return {
        items: {  Nombre: 'Gustavo A. Arellano',
                      ID: '12345',
                      Perfil: 'Entrenador' 
              }
      }
    }
}
</script>
<style>
.hidden_header {
  display: none;
}
.tab-title-class-left {
    text-align: left !important;  
}
</style>