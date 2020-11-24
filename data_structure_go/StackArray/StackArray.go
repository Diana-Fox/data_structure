package StackArray

type Stack interface {
	Clean()                //清空
	Size()                 //大小
	Pop() interface{}      //出栈
	Push(data interface{}) //入栈
	IsFull() bool          //是否满了
	IsEmpty() bool         //是否为空
}
type StackArray struct {
	dataSource  []interface{}
	capsize     int //最大范围
	currentsize int //实际大小
}
