<template>
    <div>
  <b-navbar toggleable="lg" type="dark" variant="dark">
   <div>
  <b-dropdown id="dropdown-offset" 
    split-variant="outline-light"
    variant="light" text="Menú" class="m-2">
    <b-dropdown-item href="/masterUsr/intents">Intentos</b-dropdown-item>
    <b-dropdown-item href="/masterUsr/entities">Entidades</b-dropdown-item>
  </b-dropdown>
</div>
    <b-collapse id="nav-collapse" is-nav>
      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-nav-form>
          <b-form-input size="sm" class="mr-sm-2" placeholder="..."></b-form-input>
          <b-button size="sm" class="my-2 my-sm-0" type="submit">Buscar</b-button>
        </b-nav-form>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
</template>

<script>

</script>