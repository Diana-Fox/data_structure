package ArrayList

import "errors"

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
	it := new(ArrayListIterator) //构造迭代器
	it.currentIndex = 0
	it.list = list
	return it
}

//
func (it *ArrayListIterator) HasNext() bool {
	return it.currentIndex < it.list.theSize
}

//下一个元素
func (it *ArrayListIterator) Next() (interface{}, error) {
	if !it.HasNext() {
		return nil, errors.New("无下一元素")
	}
	value, error := it.list.Get(it.currentIndex)
	it.currentIndex++
	return value, error
}

//移除
func (it *ArrayListIterator) Remove() {
	it.currentIndex--
	it.list.Delete(it.currentIndex)
}
func (it *ArrayListIterator) GetIndex() int {
	return it.currentIndex
}
