package proguard.classfile.util;

import proguard.classfile.Clazz;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.visitor.ClassVisitor;

/**
 * This class initialize members of INVOKEDYNAMIC (Workaround for #620)
 * @author Thomas Guillemard
 */
public class InvokeDynamicInitializer extends SimplifiedVisitor
        implements ConstantVisitor, ClassVisitor, AttributeVisitor
{
    private BootstrapMethodsAttribute bootstrapMethodsAttribute;

    public void visitProgramClass(ProgramClass programClass)
    {
        programClass.attributesAccept(this);
        programClass.constantPoolEntriesAccept(this);
    }

    public void visitAnyClass(Clazz clazz)
    {

    }

    public void visitAnyConstant(Clazz clazz, Constant constant)
    {

    }

    public void visitAnyAttribute(Clazz clazz, Attribute attribute)
    {

    }

    public void visitBootstrapMethodsAttribute(Clazz clazz, BootstrapMethodsAttribute bootstrapMethodsAttribute)
    {
        this.bootstrapMethodsAttribute = bootstrapMethodsAttribute;
    }

    public void visitInvokeDynamicConstant(Clazz clazz, InvokeDynamicConstant invokeDynamicConstant)
    {
        if (invokeDynamicConstant.referencedClasses != null && invokeDynamicConstant.referencedClasses.length == 1)
        {
            String name = invokeDynamicConstant.getName(clazz);
            String descriptor = null;
            BootstrapMethodInfo bootstrapMethod = bootstrapMethodsAttribute.bootstrapMethods[invokeDynamicConstant.u2bootstrapMethodAttributeIndex];

            // lambda-like structure?
            if (bootstrapMethod != null && bootstrapMethod.u2methodArgumentCount == 3)
            {
                Constant descConstant = ((ProgramClass) clazz).getConstant(bootstrapMethod.u2methodArguments[2]);
                // Assuming that we have found the descriptor
                if (descConstant instanceof MethodTypeConstant)
                    descriptor = ((MethodTypeConstant) descConstant).getType(clazz);
            }

            if (name != null && descriptor != null)
                invokeDynamicConstant.referencedMember = invokeDynamicConstant.referencedClasses[0]
                        .findMethod(name, descriptor);
        }
    }
}
