package StackArray

type StackArray interface {
	Clean()                //清空
	Size() int             //大小
	Pop() interface{}      //出栈
	Push(data interface{}) //入栈
	IsFull() bool          //是否满了
	IsEmpty() bool         //是否为空
}
type Stack struct {
	dataSource  []interface{}
	capsize     int //最大范围
	currentsize int //实际大小
}

func NewStack() *Stack {
	mystack := new(Stack)
	mystack.dataSource = make([]interface{}, 0, 10)
	mystack.capsize = 10
	mystack.currentsize = 0
	return mystack
}

func (mystack *Stack) Clean() { //清空
	mystack.dataSource = make([]interface{}, 0, 10)
	mystack.currentsize = 0
}
func (mystack *Stack) Size() int { //大小
	return mystack.currentsize
}
func (mystack *Stack) Pop() interface{} { //出栈
	if !mystack.IsEmpty() {
		last := mystack.dataSource[mystack.currentsize-1]
		mystack.dataSource = mystack.dataSource[:mystack.currentsize-1] //个人觉得删除有点鸡肋，毕竟下一次push时会覆盖，不过也可能因为我不懂golang
		mystack.currentsize--
		return last
	}

	return nil
}
func (mystack *Stack) Push(data interface{}) { //入栈
	if !mystack.IsFull() {
		mystack.dataSource = append(mystack.dataSource, data)
		mystack.currentsize++
	}
}
func (mystack *Stack) IsFull() bool { //是否满了
	return mystack.currentsize == mystack.capsize
}
func (mystack *Stack) IsEmpty() bool {
	return mystack.currentsize == 0
}
