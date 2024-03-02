<template>
    <div class="home">
      <div class="booklist">
        <h1>Book List</h1>
      </div>
    </div>
  
      <el-table :data="inventoryData" stripe style="width: 100%">
        <el-table-column prop="inventory_id" label="Inventory ID"  />
        <el-table-column prop="isbn" label="ISBN"  />
        <el-table-column prop="name" label="Book Name" />
        <el-table-column prop="author" label="Book Author" />
        <el-table-column prop="introduction" label="Book Description" />
        <el-table-column prop="status" label="Book Status"  />
        <el-table-column label="Operations">
          <template #default="scope">
            <el-button
              size="small"
              @click="handleRent(scope.$index, scope.row)"
              v-if="scope.row.status === '在庫'">可借閱</el-button>
            <el-button
            size="small"
            type="danger"
            @click="handleReturn(scope.$index, scope.row)"
            v-if="scope.row.status !== '在庫'">已借閱</el-button>
          </template>
        </el-table-column>
      </el-table>
  
  </template>
  
  <script>
    import { inject, ref, defineComponent } from 'vue'
    import { useCookies } from "vue3-cookies";
    import ax from 'axios'
    
    const { cookies } = useCookies();
  
    export default defineComponent({
      name: 'BookListView',
      setup () {
        const lsbackend = inject('lsbackend');
        const inventoryData = ref();
        const isButtonVisible = ref(true);
  
        ax.get(lsbackend + 'booklist/getBookDetail')
          .then((response) => {
            let returnBookList = response.data;
            inventoryData.value = returnBookList;
  
          })
          .catch(function (error) {
            console.log(error)
        })
  
        return { lsbackend, inventoryData, isButtonVisible };
      },
      methods: {
        handleRent(index, row) {
          let book_inventory = row.inventory_id;
          let user_id = cookies.get('userId');
          let lsbackend = this.lsbackend;
          
          if (user_id != -1){
            ax.post(lsbackend + 'inventory/rentbook',
              {
                "inventory_id": book_inventory
              })
              .then((response) => {
                console.log(response.data)
  
                ax.post(lsbackend + 'borrowingrecord/createrecord',
                {
                  "user_id": user_id,
                  "inventory_id": book_inventory,
                  "borrowing_time": Date.now()
                })
                .then( (response) => {
                  if (response.data == 1) {
                    alert("Rent book success."); 
                    location.reload();
                  }
                })
                .catch(function (error) {
                  console.log(error);
                })
  
              })
              .catch(function (error) {
                console.log(error)
              })          
          }
          else{
            alert('You need to login before rent a book.');
          }
  
        },
        handleReturn(index, row) {
          let book_inventory = row.inventory_id;
          let user_id = cookies.get('userId');    
          let lsbackend = this.lsbackend;
      
          if (user_id != -1){
            ax.post(lsbackend + 'inventory/returnbook',
              {
                "inventory_id": book_inventory
              })
              .then(() => {
                ax.post(lsbackend + 'borrowingrecord/updaterecord',
                {
                  "user_id": user_id,
                  "inventory_id": book_inventory,
                  "return_time": Date.now()
                })
                .then( (response) => {
                  if (response.data == 1) {
                    alert("Return book success."); 
                    location.reload();
                  }
                })
                .catch(function (error) {
                  console.log(error);
                })
  
              })
              .catch((error) => {
                console.log(error);
              })
          }
        }
      }
    })
  </script>