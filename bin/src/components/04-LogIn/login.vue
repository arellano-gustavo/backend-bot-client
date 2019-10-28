<template>
    <div>      
    <b-container class="text-left">
    <b-row>
        <b-col cols="4"></b-col>
        <b-col cols="4">   
            <b-card
             title=""
            :img-src='logo()'
            img-alt="Image"
            img-top
            tag="article"
            style="max-width: 20rem;"
            class="mb-2"
            >
                <b-card-text>                   
            <b-form @submit="onSubmit"  v-if="show">
              <b-form-group
                id="input-group-1"
                label="ID:"
                label-for="input-1"
                description=""
              >
                <b-form-input
                  id="input-1"
                  v-model="form.email"
                  type="number"
                  required
                  placeholder=""
                ></b-form-input>
              </b-form-group>
              <b-form-group id="input-group-2" label="Contraseña:" label-for="input-2">
                <b-form-input
                  id="input-2"
                  v-model="form.contra"
                  required
                  placeholder=""
                  type="password"
                ></b-form-input>
              </b-form-group>
              <div class="text-center">
                  <b-button type="submit" variant="success">Entrar</b-button>                  
              </div>   
              <p></p>
              <div class="text-center">
                <b-alert
                  :show="dismissCountDown"
                  dismissible
                  fade
                  variant="warning"
                  @dismiss-count-down="countDownChanged"
                >
                Espera {{ dismissCountDown }} segudos...
            </b-alert>
              </div>
            </b-form>
            
            </b-card-text>
            </b-card>
            </b-col>
            <b-col cols="4"></b-col>
            </b-row>   
            </b-container>
            
</div>
</template>
<script>

  export default {
    data() {
      return {
        form: {
          email: '',
          contra: ''           
        },
        show: true,
        dismissSecs: 5,
        dismissCountDown: 0,
        showDismissibleAlert: false
      }
    },
    methods: {  
      onSubmit(evt) {
        evt.preventDefault()                      
        this.showAlert();
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.nombre = ''    
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
      logo(){
        return require("../../assets/impi_logo.png")
      },          
      countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
         if( this.dismissCountDown === 0)
        {
          var data = JSON.stringify(this.form)
          this.validaUsr(data);
        }
      },
      showAlert() {
        this.dismissCountDown = this.dismissSecs                
      },
      validaUsr(){
          this.$router.push('/masterUsr')
      }
    }
  }
</script>