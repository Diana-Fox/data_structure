package ArrayList

//迭代器设计模式

type Iterator interface {
	HasNext() bool              //是否有下一个
	Next() (interface{}, error) //下一个元素
	Remove()                    //移除
	GetIndex() int              //得到索引
}
type Iterable interface {
	Iterator() Iterator //构造初始化接口
}

//构造指针访问数组
type ArrayListIterator struct {
	list         *ArrayList //数组指针
	currentIndex int        //当前索引

}

//
func (list *ArrayList) Iterator() Iterator {

}
