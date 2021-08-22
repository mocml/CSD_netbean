package Graph_Dijkstra;

public class Graph {
   int [][] a; int n;
   char [] v;
   Graph() {
     v = "ABCDEFGHIJKLMN".toCharArray();
   }
   void setData(int [][] b) {
       int i,j;
       n = b.length;
       a = new int[n][n];
       for(i=0;i<n;i++)
        for(j=0;j<n;j++) a[i][j]=b[i][j];       
   }
   void dispAdj() {
      int i,j;
      for(i=0;i<n;i++) {
         System.out.println();
         for(j=0;j<n;j++)
            System.out.printf("%5d", a[i][j]);
      }
      System.out.println();
   }
   void visit(int i) {
      System.out.print(v[i] + " ");
   }
    void breadth(boolean [] en, int i) {
       MyQueue q = new MyQueue();
       q.enqueue(i); en[i]=true;
       int r;
       while(!q.isEmpty()) {
         r=q.dequeue();
         visit(r);
         for(int j=0;j<n;j++)
           if(!en[j] && a[r][j]>0 ) {
              q.enqueue(j);
              en[j]=true;
           }  
       }
    }
    void breadth(int k) {
      boolean [] en = new boolean[n];
      int i,j;
      for(i=0;i<n;i++) en[i]=false;
      breadth(en,k);
      for(i=0;i<n;i++) if(!en[i]) breadth(en,i);
      
    }

    void depth(boolean [] vis, int i) {
       visit(i); vis[i]=true;
       int j;
       for(j=0;j<n;j++)
         if(!vis[j] && a[i][j]>0) {
            depth(vis,j); 
         }  
     
    }
    void depth(int k) {
      boolean [] vis = new boolean[n];
      int i,j;
      for(i=0;i<n;i++) vis[i]=false;
      depth(vis,k);
      for(i=0;i<n;i++) if(!vis[i]) depth(vis,i);
      
    }
   void dijkstra(int fro, int to) {
      boolean [] S = new boolean[n];
      int [] d = new int[n];
      int [] p = new int [n];
      int INF = 99;
      int i,j,k,t;
      for(i=0;i<n;i++) {
         S[i] = false;
         d[i] = a[fro][i];
         p[i] = fro;
      }
      S[fro] = true; // Select fro into the set S
      while(true) {
         // find k, so that d[k] = min {d[i], i not belong to S}
         t = INF;k=-1;
         for(i=0;i<n;i++) {
           if(S[i]) continue;
           if(d[i]<t) {
              t=d[i]; k=i; 
           }
         }
         if(k==-1) break; // no solution
         S[k] = true; // select k into S
         if(k==to) break;
         // update d[i] and p[i]
         for(i=0;i<n;i++) {
           if(S[i]) continue;
           if(d[i] > d[k] + a[k][i]) {
             d[i] = d[k] + a[k][i];
             p[i] = k;
           }
         }
      }
     System.out.println("The shortest distance is " + d[to]);
     MyStack s = new MyStack();
     i = to;
     s.push(i);
     while(i!=fro) {
        i = p[i];
        s.push(i);
     }
     System.out.println("The shortest path is: ");

     i = s.pop();
     
     System.out.print(i);
     while(!s.isEmpty()) {
       i = s.pop();
       System.out.print(" -> " + i);
     }
   }
    
}
