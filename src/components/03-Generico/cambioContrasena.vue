<template>
    <div>
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
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

      <b-button type="submit" variant="primary">Actualizar</b-button>
      <b-button type="reset" variant="danger">Cancelar</b-button>
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