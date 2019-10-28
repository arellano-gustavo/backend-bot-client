<template>
    <div>
      <b-form @submit="onSubmit" v-if="show">
      <b-form-group
        id="input-group-1"
        label="Nueva Contraseña:"
        label-for="input-1"
        description=""
      >
        <b-form-input
          id="input-1"
          v-model="form.contra1"   
          type="password"       
          required
          placeholder=""
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Confirmar Contraseña:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.contra2"
          type="password"
          required
          placeholder=""
        ></b-form-input>
      </b-form-group>

     <b-container class="bv-example-row">
        <b-row>
            <b-col cols="6"></b-col>
            <b-col cols="2">
                <b-button type="submit" variant="success">Actualizar</b-button>                
            </b-col>
            <b-col cols="1">
            </b-col>
            <b-col cols="2">
                <b-button @click="$bvModal.hide('modal-1')">Cancelar</b-button>
            </b-col>
        </b-row>
      </b-container>
    </b-form>
   
    </div>
</template>
<script>
export default {
    data() {
      return {
        form: {
          contra1: '',
          contra2: ''
        },        
        show: true
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.contra1 = ''
        this.form.contra2 = ''       
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>