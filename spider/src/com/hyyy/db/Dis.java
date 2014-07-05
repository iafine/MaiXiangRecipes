package com.hyyy.db;  

import java.util.Arrays; 



public class Dis { 
    private static final int inf=Integer.MAX_VALUE;//表示两个点之间无法直接连通 
    public static int[] dijkstra(int[][] graph,int n,int u){ 
        int dist[]=new int[n]; 
        boolean s[]=new boolean[n]; 
        Arrays.fill(s, false); 
        Arrays.fill(dist, inf); 
        int min,v; 
        for(int i=0;i<n;i++){ 
            dist[i]=graph[u][i]; 
        } 
        s[u]=true; 
        while(true){ 
            min=inf;v=-1; 
            //找到最小的dist 
            for(int i=0;i<n;i++){ 
                if(!s[i]){ 
                    if(dist[i]<min){min=dist[i];v=i;} 
                } 
            } 
            if(v==-1)break;//找不到更短的路径了 
            //更新最短路径 
            s[v]=true; 
            for(int i=0;i<n;i++){ 
                if(!s[i]&& 
                        graph[v][i]!=inf&& 
                        dist[v]+graph[v][i]<dist[i]){ 
                    dist[i]=dist[v]+graph[v][i]; 
                } 
            } 
        } 
        return dist; 
    } 
    public static void main(String[] args) { 
         int[][] W = {  
                    {  0,   1,   4,  inf,  inf,  inf }, 
                    {  1,   0,   2,   7,    5,  inf }, 
                    {  4,   2,   0,  inf,    1,  inf },  
                    { inf,  7,  inf,   0,    3,    2 }, 
                    { inf,  5,    1,   3,   0,    6 },  
                    { inf, inf,  inf,   2,   6,    0 } }; 
          
         int[] dist=dijkstra(W, 6, 0); 
         for (int i : dist) { 
                System.out.print(i+" "); 
            } 
         System.out.println(); 
    } 
} 
