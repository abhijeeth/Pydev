// Autogenerated AST node
package org.python.parser.ast;
import org.python.parser.SimpleNode;
import java.io.DataOutputStream;
import java.io.IOException;

public class UnaryOp extends exprType implements unaryopType {
	public int op;
	public exprType operand;

	public UnaryOp(int op, exprType operand) {
		this.op = op;
		this.operand = operand;
	}

	public UnaryOp(int op, exprType operand, SimpleNode parent) {
		this(op, operand);
		this.beginLine = parent.beginLine;
		this.beginColumn = parent.beginColumn;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("UnaryOp[");
		sb.append("op=");
		sb.append(dumpThis(this.op, unaryopType.unaryopTypeNames));
		sb.append(", ");
		sb.append("operand=");
		sb.append(dumpThis(this.operand));
		sb.append("]");
		return sb.toString();
	}

	public void pickle(DataOutputStream ostream) throws IOException {
		pickleThis(30, ostream);
		pickleThis(this.op, ostream);
		pickleThis(this.operand, ostream);
	}

	public Object accept(VisitorIF visitor) throws Exception {
		return visitor.visitUnaryOp(this);
	}

	public void traverse(VisitorIF visitor) throws Exception {
		if (operand != null)
			operand.accept(visitor);
	}

}
