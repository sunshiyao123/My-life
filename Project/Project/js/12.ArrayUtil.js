/**
 * 设计ArrayUtil对象，给当前对象中设计两个方法
 * search(array,target):在指定array数组中查询target元素第一次在数组中出现的索引
 * max(array):获取array数组中的最大值
 */
function ArrayUtil() {
	// 追加两个方法
	this.search = function(array,target) {
		for (var i = 0; i < array.length; i++) {
			if(array[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	this.max = function(array) {
		var max = array[0];
		for(var i = 0;i < array.length;i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
}