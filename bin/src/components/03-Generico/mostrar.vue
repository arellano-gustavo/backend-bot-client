<template>
<div>
    <b-table bordered small light hover head-variant="light" :items="items" :fields="fields" select-mode="single" selectable @row-selected="onRowSelected"></b-table>
</div>
</template>

<script>
export default {
    props: ['items'],
    selected: [],
     methods: {
      onRowSelected(items) {
        this.selected = items
        alert(JSON.stringify(items))
      }
     }
}
</script>
