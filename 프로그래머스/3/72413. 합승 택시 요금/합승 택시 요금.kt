import java.util.*
import kotlin.math.*
 
class Solution {
    private lateinit var graph: Array<ArrayList<Node>>
    private var size = 0
    
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE
        size = n
        graph = Array(size+1){ArrayList<Node>()}
        fares.forEach{ fare ->
            graph[fare[0]].add(Node(fare[1], fare[2]))
            graph[fare[1]].add(Node(fare[0], fare[2]))
        }
        val sDist = dijektra(s)
        val aDist = dijektra(a)
        val bDist = dijektra(b)
        for(i in 1..n){
            if(sDist[i] == Int.MAX_VALUE || aDist[i] == Int.MAX_VALUE || bDist[i] == Int.MAX_VALUE) continue
            answer = min(answer, sDist[i] + aDist[i] + bDist[i])
        }
        
        return answer
    }
    
    private fun dijektra(start: Int): IntArray {
        val visited = BooleanArray(size + 1) {false}
        val dst = IntArray(size + 1) {Int.MAX_VALUE}
        
        val heapq = PriorityQueue<Node>()
        val startNode = Node(start ,0)
        dst[start] = 0
        heapq.offer(startNode)
        while(heapq.isNotEmpty()){
            val node = heapq.poll()
            if(visited[node.idx]) continue
            graph[node.idx].forEach{ connected ->
                if(dst[connected.idx] > dst[node.idx] + connected.weight){
                    dst[connected.idx] = dst[node.idx] + connected.weight
                    heapq.offer(Node(connected.idx, dst[connected.idx]))
                }
            }
        }
        return dst
    }
    
    
    
}

data class Node(val idx: Int, val weight: Int): Comparable<Node>{
    override fun compareTo(other: Node): Int{
        return weight - other.weight
    }
}
