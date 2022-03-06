package com.tes;
import java.util.Scanner;
import java.util.LinkedList;

public class TugasDoubleLinkedList {
	 private Node head;
	  private Node tail;
	  private int size = 0;
	  
	  static class Node{
	    int data;
	    Node next;
	    Node prev;
	    Node(int data){
	      this.data = data;
	      prev = null;
	      next = null;
	    }
	   
	    public void printList(){
	      System.out.print( data+" ");
	    }
	  }
	  
	  public TugasDoubleLinkedList(){
	    this.head = null;
	    this.tail = null;
	  }

	  public boolean is_empty(){
	    return head == null;
	  }
	    
	  public void addFirst(int data){
	    Node new_node = new Node(data);
	    
	    if(is_empty()){
	        tail = new_node;
	    }else{
	        head.prev = new_node;
	    }
	    new_node.next = head;
	    head = new_node;
	    size++;
	  }

	  public void addLast(int data){
	    Node new_node = new Node(data);
	    
	    if(is_empty()){
	      head = new_node;
	    }else{
	      tail.next = new_node;
	      new_node.prev = tail;
	    }
	    tail = new_node;
	    size++;
	  }
	    
	  public void add(int data, int index){
	    if(!isValidIndex(index)){
	      throw new IndexOutOfBoundsException("Index " + index +" not valid for linked list of size " + size);
	    }
	    Node newNode = new Node(data);
	    Node current = head;
	    
	    if(index == 0){
	      addFirst(data);
	    }
	   
	    else if(index == size){
	      addLast(data);
	    }else{
	      for(int j = 0; j < index && current.next != null; j++){
	        current = current.next;
	      }
	      newNode.next = current;
	      current.prev.next = newNode;
	      newNode.prev = current.prev;
	      current.prev = newNode;
	      size++;    
	    }      
	  }
	    
	  public Node removeFirst(){
	    if(head == null){
	      throw new RuntimeException("List is empty");
	    }
	    Node first = head;
	    if(head.next == null){
	      tail = null;
	    }else{
	      head.next.prev = null;
	    }
	    head = head.next;
	    size--;
	    return first;
	  }
	    
	  public Node removeLast(){
	    if(tail == null){
	      throw new RuntimeException("List is empty");
	    }
	    Node last = tail;
	    if(head.next == null){
	      head = null;
	    }else{
	      tail.prev.next = null;
	    }
	    tail = tail.prev;
	    size--;
	    return last;
	  }

	  public Node remove(int index){
	    if(!isValidIndex(index+1)){
	      throw new IndexOutOfBoundsException("Index " + index +" not valid for linked list of size " + size);
	    }
	    Node current = head;
	   
	    if(index == 0){
	      return removeFirst();
	    }
	   
	    else if(index == size-1){
	      return removeLast();
	    }else{
	      for(int j = 0; j < index && current.next != null; j++){
	        current = current.next;
	      }
	      current.prev.next = current.next;
	      current.next.prev = current.prev;
	      size--;
	    }
	    
	    return current;
	  }
	    
	  private boolean isValidIndex(int index){
	    return index >= 0 && index <= size;
	  }
	   
	  public boolean find(int data) {
		  boolean flag = false;
		  Node current = head;
		  while(current != null) {
			  if(current.data == data) {
				  flag = true;
				  break;
			  }
			  current = current.next;
		  }
		  return flag;
	  }
	  
	  public boolean replace(int data, int index) {
			Node current = head;
	        Node prev = null;
	        
	        while (current != null && index >= 0) {
	            index--;
	            prev = current;
	            current = current.next;
	        }
	        if (index > 0)
				return false;

			if (prev != null)
	            prev.data = data;
				System.out.println("    Data berhasil diubah");
	        	return true;
	    }
	    
	 
	  public void printList(boolean asc){
		  Node current = null;
		  if(asc) 
			  current = head;
		  else
			  current = tail;
		  
			System.out.print("    [ ");
			while(current != null){
				current.printList();
				if(asc)
					current = current.next;
				else
					current = current.prev;
			}
			System.out.print("]\n\n");
		}
	  

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
			
			
		TugasDoubleLinkedList list = new TugasDoubleLinkedList();
		int pilih; int pilih2;  int index = 0; 
		int x = 0000;
		char input;
	  	boolean lanjut;
	  	int user_data;
		boolean asc = true;
	  

		do {
			System.out.println("*** DOUBLE LINKED LIST ***");
			System.out.println("    1. Manual");
			System.out.println("    2. Pustaka");
			System.out.println("    3. Keluar");
			System.out.print("    Silahkan pilih [1/2/3]: ");
			pilih  = userInput.nextInt();
			System.out.println();
					
			switch(pilih) {
			case 1:
				do {
					System.out.println("*** OPERASI DOUBLE LINKED LIST ***");
					System.out.println("    1. Tambah Data");
					System.out.println("    2. Hapus Data");
					System.out.println("    3. Pencarian/Pengubahan Data");
					System.out.println("    4. Kembali");
					System.out.print("    Silahkan pilih [1/2/3/4]: ");
					pilih  = userInput.nextInt();
					System.out.println();
						
					switch(pilih) {
					case 1:
						do {
							System.out.println("*** OPERASI TAMBAH DATA DOUBLE LINKED LIST ***");
							System.out.println("    1. Tambah Data Awal ");
							System.out.println("    2. Tambah Data Tengah");
							System.out.println("    3. Tambah Data Akhir");
							System.out.println("    4. Cetak Data");
							System.out.println("    5. Kembali");
							System.out.print("    Silahkan pilih [1/2/3/4/5]: ");
							pilih = userInput.nextInt();
							System.out.println();
							
							switch(pilih) {
							
							case 1:
								lanjut = true;
								System.out.println("    INFO: - Masukan data angka (integer)\n"
										+ "          - Tekan 0000 untuk kembali ke menu sebelumnya\n");
								while(lanjut) {
									for(int i = 0; i < i+1; i++) {
										System.out.print("    Data ke-" + (i+1) +": ");
										user_data = userInput.nextInt();
										if(user_data == x ){
											lanjut = false;
											break;
										}
										list.addFirst(user_data);
									}
									System.out.println();
								}			
								break;
								
							case 2:
								lanjut = true;
								System.out.println("    INFO: - Masukan data angka (integer)\n"
										+ "          - Tekan 0000 untuk kembali ke menu sebelumnya\n");
								
								
								while(lanjut) {
									for(int i = 0; i < i+1; i++) {		
										System.out.print("    Apakah yakin ingin melanjutkan [y/t]: ");
	  									input = userInput.next().charAt(0);
	  									if(input == 't' || input == 'T' ){
	  										lanjut = false;
	  										break;
	  									}
	  									System.out.print("    Masukan Node: ");
										index = userInput.nextInt();
										System.out.print("    Masukan Data: ");
										user_data = userInput.nextInt();
										
										list.add(user_data,index);	
									}
									System.out.println();
								}			
								break;
								
							case 3:
								lanjut = true;
								System.out.println("    INFO: - Masukan data angka (integer)\n"
										+ "          - Tekan 0000 untuk kembali ke menu sebelumnya\n");
								while(lanjut) {
									for(int i = 0; i < i+1; i++) {
										System.out.print("    Data ke-" + (i+1) +": ");
										user_data = userInput.nextInt();
										if(user_data == x ){
											lanjut = false;
											break;
										}
										list.addLast(user_data);
									}
									System.out.println();
								}
								break;
	  	
							case 4:
								list.printList(asc);
	  							break;
							}
	  						
	  	
						}while(pilih != 5);
						break;

					case 2: 
						do {
							System.out.println("*** OPERASI HAPUS DATA DOUBLE LINKED LIST ***");
							System.out.println("    1. Hapus Data Awal ");
							System.out.println("    2. Hapus Data Tengah");
							System.out.println("    3. Hapus Data Akhir");
							System.out.println("    4. Cetak Data");
							System.out.println("    5. Kembali");
							System.out.print("    Silahkan pilih [1/2/3/4/5]: ");
							pilih = userInput.nextInt();
							System.out.println();
							
							switch(pilih) {
							case 1:
								lanjut = true;
								while(lanjut){
									for(int i = 0; i < i+1; i++) {
										System.out.print("    Yakin ingin menghapus data di awal?[y/t] ");
										input = userInput.next().charAt(0);
										if(input == 't'||input == 'T') {
											lanjut = false;
											break;
										}
										list.removeFirst();
									}
									System.out.println();
								}
								break;
							
							case 2:
								Node node = null;
								lanjut = true;
								while(lanjut) {
									for(int i = 0; i < i+1; i++) {
	  									System.out.print("    Yakin ingin menghapus data di tengah?[y/t] ");
										input = userInput.next().charAt(0);
									
	  									if(input == 't'||input == 'T') {
											lanjut = false;
											break;
										}
										System.out.print("    Masukan Node: ");
										index = userInput.nextInt();
										node = list.remove(index);
									}
	  								System.out.println("    Node with value "+node.data+" was deleted\n");
	  							}
	  							break;
	  						
	  						case 3:
	  							lanjut = true;
	  							while(lanjut) {
	  								for(int i = 0; i < i+1; i++) {
										System.out.print("    Yakin ingin menghapus data di akhir?[y/t] ");
										input = userInput.next().charAt(0);
										if(input == 't'||input == 'T') {
											lanjut = false;
											break;
										}
										list.removeLast();
									}
	  								System.out.println();
	  							}
	  							break;
	  	
							case 4: 
								list.printList(asc);
								break;
							}
						}while(pilih != 5);
						break;
					
					case 3:
						do {
							System.out.println("*** OPERASI PENCARIAN/PENGUBAHAN DATA DOUBLE LINKED LIST ***");
							System.out.println("    1. Cari Data");
							System.out.println("    2. Ubah Data");
							System.out.println("    3. Cetak Data");
							System.out.println("    4. Kembali");
							System.out.print("    Silahkan pilih [1/2/3/4]: ");
							pilih2  = userInput.nextInt();
							System.out.println();
							
							switch(pilih2) {
							case 1:
								lanjut = true;
								while(lanjut) {
									for(int i = 0; i < i+1; i++) {
										System.out.print("    Operasi Pencarian data\n"+"    Lanjut[y/t]: ");
										input = userInput.next().charAt(0);
										if(input == 't'||input == 't') {
											lanjut = false;
											break;
										}
										System.out.print("    Masukan data: ");
										user_data = userInput.nextInt();
										
										if(list.find(user_data)) 
											System.out.println("    Data ditemukan");
										else 
											System.out.println("    Data tidak ditemukan");
									}
									System.out.println();
								}
								break;
							case 2:
								lanjut = true;
								while(lanjut) {
									for(int i = 0; i < i+1; i++) {
										System.out.print("    Operasi Pengubahan data\n"+"    Lanjut[y/t]: ");
										input = userInput.next().charAt(0);
										if(input == 't'||input == 'T') {
						    				lanjut = false;
						    				break;
						    			}
										System.out.print("    Masukan Node: ");
										index = userInput.nextInt();
										System.out.print("    Masukan Data: ");
										user_data = userInput.nextInt();
										list.replace(user_data, index);
									}
									System.out.println();
								}
								break;
							case 3:
								list.printList(asc);
								break;
							}
						}while(pilih2 != 4);
						break;
					}
					
				}while(pilih != 4);
				break;
			case 2:
				LinkedList <Integer>llist = new LinkedList<>();
				do {
					System.out.println("*** OPERASI DOUBLE LINKED LIST ***");
					System.out.println("    1. Tambah Data");
					System.out.println("    2. Hapus Data");
					System.out.println("    3. Pencarian/Pengubahan Data");
					System.out.println("    4. Kembali");
					System.out.print("    Silahkan pilih [1/2/3/4]: ");
					pilih  = userInput.nextInt();
					System.out.println();
						
					switch(pilih) {
					case 1:
						do {
							System.out.println("*** OPERASI TAMBAH DATA DOUBLE LINKED LIST ***");
							System.out.println("    1. Tambah Data Awal ");
							System.out.println("    2. Tambah Data Tengah");
							System.out.println("    3. Tambah Data Akhir");
							System.out.println("    4. Cetak Data");
							System.out.println("    5. Kembali");
							System.out.print("    Silahkan pilih [1/2/3/4/5]: ");
							pilih = userInput.nextInt();
							System.out.println();
							
							switch(pilih) {
							
							case 1:
								lanjut = true;
								System.out.println("    INFO: - Masukan data angka (integer)\n"
										+ "          - Tekan 0000 untuk kembali ke menu sebelumnya\n");
								while(lanjut) {
									for(int i = 0; i < i+1; i++) {
										System.out.print("    Data ke-" + (i+1) +": ");
										user_data = userInput.nextInt();
										if(user_data == x ){
											lanjut = false;
											break;
										}
										llist.addFirst(user_data);
									}
									System.out.println();
								}			
								break;
								
							case 2:
								lanjut = true;
								System.out.println("    INFO: - Masukan data angka (integer)\n"
										+ "          - Tekan 0000 untuk kembali ke menu sebelumnya\n");
								while(lanjut) {
									for(int i = 0; i < i+1; i++) {		
										System.out.print("    Apakah yakin ingin melanjutkan [y/t]: ");
	  									input = userInput.next().charAt(0);
	  									if(input == 't' || input == 'T' ){
	  										lanjut = false;
	  										break;
	  									}
	  									System.out.print("    Masukan Node: ");
										index = userInput.nextInt();
										System.out.print("    Masukan Data: ");
										user_data = userInput.nextInt();
										
										llist.add(index,user_data);	
									}
									System.out.println();
								}			
								break;
								
							case 3:
								lanjut = true;
								System.out.println("    INFO: - Masukan data angka (integer)\n"
										+ "          - Tekan 0000 untuk kembali ke menu sebelumnya\n");
								while(lanjut) {
									for(int i = 0; i < i+1; i++) {
										System.out.print("    Data ke-" + (i+1) +": ");
										user_data = userInput.nextInt();
										if(user_data == x ){
											lanjut = false;
											break;
										}
										llist.addLast(user_data);
									}
									System.out.println();
								}
								break;
	  	
							case 4:
								System.out.println("    "+llist+"\n");
	  							break;
							}
	  						
	  	
						}while(pilih != 5);
						break;

					case 2: 
						do {
							System.out.println("*** OPERASI HAPUS DATA DOUBLE LINKED LIST ***");
							System.out.println("    1. Hapus Data Awal ");
							System.out.println("    2. Hapus Data Tengah");
							System.out.println("    3. Hapus Data Akhir");
							System.out.println("    4. Cetak Data");
							System.out.println("    5. Kembali");
							System.out.print("    Silahkan pilih [1/2/3/4/5]: ");
							pilih = userInput.nextInt();
							System.out.println();
							
							switch(pilih) {
							case 1:
								lanjut = true;
								while(lanjut){
									for(int i = 0; i < i+1; i++) {
										System.out.print("    Yakin ingin menghapus data di awal?[y/t] ");
										input = userInput.next().charAt(0);
										if(input == 't'||input == 'T') {
											lanjut = false;
											break;
										}
										llist.removeFirst();
									}
									System.out.println();
								}
								break;
							
							case 2:
								lanjut = true;
								while(lanjut) {
									for(int i = 0; i < i+1; i++) {
	  									System.out.print("    Yakin ingin menghapus data di tengah?[y/t] ");
										input = userInput.next().charAt(0);
									
	  									if(input == 't'||input == 'T') {
											lanjut = false;
											break;
										}
										System.out.print("    Masukan Node: ");
										index = userInput.nextInt();
										llist.remove(index);
									}
									System.out.println();
	  							}
	  							break;
	  						
	  						case 3:
	  							lanjut = true;
	  							while(lanjut) {
	  								for(int i = 0; i < i+1; i++) {
										System.out.print("    Yakin ingin menghapus data di akhir?[y/t] ");
										input = userInput.next().charAt(0);
										if(input == 't'||input == 'T') {
											lanjut = false;
											break;
										}
										llist.removeLast();
									}
	  								System.out.println();
	  							}
	  							break;
	  	
							case 4: 
								System.out.println("    "+llist+"\n");
								break;
							}
						}while(pilih != 5);
						break;
					
					case 3:
						do {
							System.out.println("*** OPERASI PENCARIAN/PENGUBAHAN DATA DOUBLE LINKED LIST ***");
							System.out.println("    1. Cari Data");
							System.out.println("    2. Ubah Data");
							System.out.println("    3. Cetak Data");
							System.out.println("    4. Kembali");
							System.out.print("    Silahkan pilih [1/2/3/4]: ");
							pilih2  = userInput.nextInt();
							System.out.println();
							
							switch(pilih2) {
							case 1:
								lanjut = true;
								while(lanjut) {
									boolean flag = false;
									for(int i = 0; i < i+1; i++) {
										System.out.print("    Operasi Pencarian data\n"+"    Lanjut[y/t]: ");
										input = userInput.next().charAt(0);
										if(input == 't'||input == 't') {
											lanjut = false;
											break;
										}
										System.out.print("    Masukan data: ");
										user_data = userInput.nextInt();
										
										for(int j = 0; j < llist.size(); j++) {
											if(llist.get(j) == user_data) {
												System.out.println("    Data "+user_data+" Ditemukan");
												flag = true;
												break;
											}
										}
										if(!flag) {
											System.out.println("    Data tidak ditemukan");
										}
										
									}
									System.out.println();
								}
								break;
							case 2:
								lanjut = true;
								while(lanjut) {
									boolean flag = false;
									for(int i = 0; i < i+1; i++) {
										System.out.print("    Operasi Pengubahan data\n"+"    Lanjut[y/t]: ");
										input = userInput.next().charAt(0);
										if(input == 't'||input == 'T') {
						    				lanjut = false;
						    				break;
						    			}
										System.out.print("    Masukan Node: ");
										index = userInput.nextInt();
										System.out.print("    Masukan Data: ");
										user_data = userInput.nextInt();
										for(int j = 0; j < llist.size(); j++) {
											if(j == index) {
												llist.set(j, user_data);
												flag = true;
											}
										}
										if(!flag) {
											System.out.println("    Data tidak ditemukan");
										}
									
									}
									System.out.println();
								}
								break;
							case 3:
								System.out.println("    "+llist+"\n");
								break;
							}
						}while(pilih2 != 4);
						break;
					}
					
				}while(pilih != 4);
			
			break;
			}
		}while(pilih != 3);
		
	}

}
