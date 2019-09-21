<template>
    <div>
      <b-modal id="modal-1" title="CAMBIAR CONTRASEÑA" hide-footer>
        <cambioMiPass></cambioMiPass>
      </b-modal> 
      <b-modal id="modal-2" title="ALTA USUARIO" hide-footer>
        <modalusr></modalusr>
      </b-modal>
       <b-modal id="modal-3" title="ALTA ÁREA" hide-footer>
        <modalarea></modalarea>
      </b-modal>

      <b-container class="bv-example-row">
        <b-row>
          <b-col></b-col>
          <b-col></b-col>
          <b-col>
            <b-table small Fixed  :items="items" :fields="fields" thead-class="hidden_header"></b-table>
          </b-col>
        </b-row>   
      </b-container>    
    <b-card no-body>
    <b-tabs pills card vertical>
      <b-tab title="Usuarios" active  :title-item-class="'tab-title-class-left'">
        <b-card-text>     
          <gridCatUsr></gridCatUsr>  
          <b-button variant="success" v-b-modal.modal-2>Agregar Usuario</b-button>
        </b-card-text>
      </b-tab>
      <b-tab title="Areas" :title-item-class="'tab-title-class-left'">
        <b-card-text>      
          <gridCatArea></gridCatArea> 
          <b-button variant="success" v-b-modal.modal-3>Agregar Área</b-button>
        </b-card-text>
      </b-tab>
      <b-tab title="Cambiar Mi Contraseña" @click="$bvModal.show('modal-1')" :title-item-class="'tab-title-class-left'">        
      </b-tab>
      <b-tab title="Salir del Sistema" :title-item-class="'tab-title-class-left'">
        <b-card-text>Salir del Sistema</b-card-text>
      </b-tab> 
    </b-tabs>
  </b-card>
</div>
</template>
<script>
import cambioMiPass from "../03-Generico/cambioContrasena"
import gridCatUsr from './01-catalogoUsuario/gridCatUsuario'
import gridCatArea from './02-catalogoArea/gridCatArea'
import modalusr from './01-catalogoUsuario/modalUsr'
import modalarea from './02-catalogoArea/modalArea'
export default {
    components:{
        cambioMiPass,
        gridCatUsr,
        gridCatArea,
        modalusr,
        modalarea
    },
     data() {
      return {
        // Note `isActive` is left out and will not appear in the rendered table
        fields: ['campo', 'valor'],
        items: [
          { campo: 'Usuario Firmado:', valor: 'Gustavo A. Arellano' },
          { campo: 'ID:', valor: '12345' },
          { campo: 'Rol:', valor: 'Administrador' }          
        ]
       
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