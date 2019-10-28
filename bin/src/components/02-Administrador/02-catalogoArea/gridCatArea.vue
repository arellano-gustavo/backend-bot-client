<template>
  <div>
    <b-modal :id="infoModalarea.id" title="EDITAR ÁREA" ok-only  hide-footer>
      <modalareaEditar></modalareaEditar>           
      <pre>{{ infoModalarea.content }}</pre>
      </b-modal>
      <b-table bordered
        show-empty
        small    
        head-variant="light"      
        :items="items"
        :fields="fields">
        <template v-slot:cell(editar)="row">
        <b-button size="sm" @click="infoa(row.item, row.index, $event.target)" class="mr-1">
          Editar
        </b-button>       
      </template>          
        </b-table>         
    </div>
</template>
<script>
import modalareaEditar from './modalAreaEditar.vue'
export default {
   components:{
     modalareaEditar
   },
    data() {
      return {
        items: [
          { ID: 12341, nombre: 'Área 1' },
          { ID: 12342, nombre: 'Área 2' },
          { ID: 12343, nombre: 'Área 3' },
          { ID: 12344, nombre: 'Área 4' }
        ],
        fields: [
            { key: 'ID', label: 'ID ' },
            { key: 'nombre', label: 'Nombre de Área' },
            { key: 'editar', label: 'Editar' }            
         ],         
         infoModalarea: {
          id: 'info-modal2',
          title: '',
          content: ''
        }       
      }
    },    
     methods: {
     infoa(item, index, button) {
        this.infoModalarea.title = `Row index: ${index}`
        this.infoModalarea.content = JSON.stringify(item, null, 2)
        this.$root.$emit('bv::show::modal', this.infoModalarea.id, button)
      }
  }
}
</script>