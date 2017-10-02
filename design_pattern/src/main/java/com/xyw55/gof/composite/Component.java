package com.xyw55.gof.composite;

/**
 * Created by xiayiwei on 12/10/16.
 */
public interface Component {
}

// 叶子节点
interface Leaf extends Component {

}

// 容器节点
interface Composite extends Component {
    void add(Component component);

    void remove(Component component);

    Component getChild(int index);
}
