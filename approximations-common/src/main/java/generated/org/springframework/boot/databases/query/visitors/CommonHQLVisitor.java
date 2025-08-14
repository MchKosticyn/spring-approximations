package generated.org.springframework.boot.databases.query.visitors;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.hibernate.grammars.hql.HqlLexer;
import org.hibernate.grammars.hql.HqlParser;
import org.hibernate.grammars.hql.HqlParserVisitor;
import org.hibernate.internal.util.QuotingHelper;
import org.hibernate.type.descriptor.java.PrimitiveByteArrayJavaType;
import org.usvm.spring.query.From;
import org.usvm.spring.query.GroupBy;
import org.usvm.spring.query.Having;
import org.usvm.spring.query.Order;
import org.usvm.spring.query.Query;
import org.usvm.spring.query.Select;
import org.usvm.spring.query.TableWithJoins;
import org.usvm.spring.query.Where;
import org.usvm.spring.query.expression.AExpression;
import org.usvm.spring.query.expression.functions.BinOperator;
import org.usvm.spring.query.expression.functions.FOperator;
import org.usvm.spring.query.expression.functions.Id;
import org.usvm.spring.query.expression.functions.Minus;
import org.usvm.spring.query.expression.functions.NaturalId;
import org.usvm.spring.query.expression.functions.TypeOfParameter;
import org.usvm.spring.query.expression.functions.TypeOfPath;
import org.usvm.spring.query.expression.functions.Version;
import org.usvm.spring.query.expression.literals.LBigDecimal;
import org.usvm.spring.query.expression.literals.LBigInt;
import org.usvm.spring.query.expression.literals.LBinary;
import org.usvm.spring.query.expression.literals.LBool;
import org.usvm.spring.query.expression.literals.LDouble;
import org.usvm.spring.query.expression.literals.LFloat;
import org.usvm.spring.query.expression.literals.LInt;
import org.usvm.spring.query.expression.literals.LLong;
import org.usvm.spring.query.expression.literals.LNull;
import org.usvm.spring.query.expression.literals.LString;
import org.usvm.spring.query.expression.paths.ExprPath;
import org.usvm.spring.query.expression.paths.SyntacticPath;
import org.usvm.spring.query.expression.special.Parameter;
import org.usvm.spring.query.expression.special.Subquery;
import org.usvm.spring.query.expression.special.Tuple;
import org.usvm.spring.query.expression.special.cases.BranchCtx;
import org.usvm.spring.query.expression.special.cases.CaseList;
import org.usvm.spring.query.expression.special.cases.SimpleCaseList;
import org.usvm.spring.query.function.FunctionType;
import org.usvm.spring.query.function.SqlFunction;
import org.usvm.spring.query.join.AJoin;
import org.usvm.spring.query.join.common.CommonJoin;
import org.usvm.spring.query.join.common.CommonJoinType;
import org.usvm.spring.query.parameter.AParameter;
import org.usvm.spring.query.parameter.Colon;
import org.usvm.spring.query.parameter.Positional;
import org.usvm.spring.query.paramorint.AParamOrInt;
import org.usvm.spring.query.paramorint.Num;
import org.usvm.spring.query.paramorint.Param;
import org.usvm.spring.query.path.GeneralPath;
import org.usvm.spring.query.path.Index;
import org.usvm.spring.query.path.Path;
import org.usvm.spring.query.path.SimplePath;
import org.usvm.spring.query.predicate.And;
import org.usvm.spring.query.predicate.Not;
import org.usvm.spring.query.predicate.Or;
import org.usvm.spring.query.predicate.functions.Between;
import org.usvm.spring.query.predicate.functions.Exist;
import org.usvm.spring.query.predicate.functions.InFunction.AInValues;
import org.usvm.spring.query.predicate.functions.InFunction.InFunction;
import org.usvm.spring.query.predicate.functions.InFunction.ListIn;
import org.usvm.spring.query.predicate.functions.InFunction.ParameterIn;
import org.usvm.spring.query.predicate.functions.IsDistinct;
import org.usvm.spring.query.predicate.functions.IsEmpty;
import org.usvm.spring.query.predicate.functions.IsNull;
import org.usvm.spring.query.predicate.functions.IsTrue;
import org.usvm.spring.query.predicate.functions.Like;
import org.usvm.spring.query.predicate.functions.Member;
import org.usvm.spring.query.predicate.functions.compare.Compare;
import org.usvm.spring.query.predicate.functions.compare.Operator;
import org.usvm.spring.query.predicate.functions.existcollection.ColQuantifierCtx;
import org.usvm.spring.query.predicate.functions.existcollection.ExistCollection;
import org.usvm.spring.query.selectfun.ASelection;
import org.usvm.spring.query.selectfun.Entry;
import org.usvm.spring.query.selectfun.Expression;
import org.usvm.spring.query.selectfun.Instance;
import org.usvm.spring.query.selectfun.JpaSelect;
import org.usvm.spring.query.selectfun.SelectFunction;
import org.usvm.spring.query.specification.ASpecification;
import org.usvm.spring.query.specification.ByExpression;
import org.usvm.spring.query.specification.ByIdentity;
import org.usvm.spring.query.specification.ByPosition;
import org.usvm.spring.query.specification.GroupBySpecification;
import org.usvm.spring.query.specification.SortSpecification;
import org.usvm.spring.query.table.ATable;
import org.usvm.spring.query.table.EntityName;
import org.usvm.spring.query.table.TableRoot;
import org.usvm.spring.query.table.TableSubquery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hibernate.internal.util.QuotingHelper.unquoteJavaStringLiteral;
import static org.hibernate.internal.util.QuotingHelper.unquoteStringLiteral;

public class CommonHQLVisitor extends AbstractParseTreeVisitor<Object> implements HqlParserVisitor<Object> {

    @Override
    public Object visitStatement(HqlParser.StatementContext ctx) {
        return visit(ctx.getChild(0)); // TODO: switch by type of statement
    }

    @Override
    public Select visitSelectStatement(HqlParser.SelectStatementContext ctx) {
        return (Select) visitChildren(ctx);
    }

    @Override
    public Select visitSubquery(HqlParser.SubqueryContext ctx) {
        return (Select) visitChildren(ctx);
    }

    @Override
    public Object visitTargetEntity(HqlParser.TargetEntityContext targetEntityContext) {
        return null;
    }

    @Override
    public Object visitDeleteStatement(HqlParser.DeleteStatementContext deleteStatementContext) {
        return null;
    }

    @Override
    public Object visitUpdateStatement(HqlParser.UpdateStatementContext updateStatementContext) {
        return null;
    }

    @Override
    public Object visitSetClause(HqlParser.SetClauseContext setClauseContext) {
        return null;
    }

    @Override
    public Object visitAssignment(HqlParser.AssignmentContext assignmentContext) {
        return null;
    }

    @Override
    public Object visitInsertStatement(HqlParser.InsertStatementContext insertStatementContext) {
        return null;
    }

    @Override
    public Object visitTargetFields(HqlParser.TargetFieldsContext targetFieldsContext) {
        return null;
    }

    @Override
    public Object visitValuesList(HqlParser.ValuesListContext valuesListContext) {
        return null;
    }

    @Override
    public Object visitValues(HqlParser.ValuesContext valuesContext) {
        return null;
    }

    @Override
    public Object visitConflictClause(HqlParser.ConflictClauseContext conflictClauseContext) {
        return null;
    }

    @Override
    public Object visitConflictTarget(HqlParser.ConflictTargetContext conflictTargetContext) {
        return null;
    }

    @Override
    public Object visitConflictAction(HqlParser.ConflictActionContext conflictActionContext) {
        return null;
    }

    @Override
    public Object visitWithClause(HqlParser.WithClauseContext withClauseContext) {
        return null;
    }

    @Override
    public Object visitCte(HqlParser.CteContext cteContext) {
        return null;
    }

    @Override
    public Object visitCteAttributes(HqlParser.CteAttributesContext cteAttributesContext) {
        return null;
    }

    @Override
    public Object visitSearchClause(HqlParser.SearchClauseContext searchClauseContext) {
        return null;
    }

    @Override
    public Object visitSearchSpecifications(HqlParser.SearchSpecificationsContext searchSpecificationsContext) {
        return null;
    }

    @Override
    public Object visitSearchSpecification(HqlParser.SearchSpecificationContext searchSpecificationContext) {
        return null;
    }

    @Override
    public Object visitCycleClause(HqlParser.CycleClauseContext cycleClauseContext) {
        return null;
    }

    @Override
    public Select visitSimpleQueryGroup(HqlParser.SimpleQueryGroupContext ctx) {
        // val with = visit(ctx.withClause()) // TODO: https://www.geeksforgeeks.org/sql-with-clause/
        return (Select) visit(ctx.orderedQuery());
    }

    @Override
    public Object visitSetQueryGroup(HqlParser.SetQueryGroupContext setQueryGroupContext) {
        return null;
    }

    @Override
    public Select visitQuerySpecExpression(HqlParser.QuerySpecExpressionContext ctx) {
        List<Order> order = visitQueryOrder(ctx.queryOrder());
        Query query = visitQuery(ctx.query());
        return new Select(order, query);
    }

    @Override
    public Select visitNestedQueryExpression(HqlParser.NestedQueryExpressionContext ctx) {
        List<Order> order = visitQueryOrder(ctx.queryOrder());
        Select subQuery = (Select) visit(ctx.queryExpression());
        subQuery.orders = order;
        return subQuery;
    }

    @Override
    public Object visitQueryOrderExpression(HqlParser.QueryOrderExpressionContext queryOrderExpressionContext) {
        return null;
    }

    @Override
    public Object visitSetOperator(HqlParser.SetOperatorContext setOperatorContext) {
        return null;
    }

    @Override
    public List<Order> visitQueryOrder(HqlParser.QueryOrderContext ctx) {
        if (ctx == null) return new ArrayList<Order>();
        AParamOrInt limit = visitLimitClause(ctx.limitClause());
        AParamOrInt offset = visitOffsetClause(ctx.offsetClause());
        // val fetch = visitFetchClause(ctx.fetchClause()) TODO:
        Order order = visitOrderByClause(ctx.orderByClause());
        order.limit = limit;
        order.offset = offset;
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);
        return orders;
    }

    @Override
    public Query visitQuery(HqlParser.QueryContext ctx) {
        From from = visitFromClause(ctx.fromClause());
        Where where = visitWhereClause(ctx.whereClause());
        SelectFunction select = visitSelectClause(ctx.selectClause());
        GroupBy group = visitGroupByClause(ctx.groupByClause());
        Having having = visitHavingClause(ctx.havingClause());
        return new Query(from, where, select, group, having);
    }

    @Override
    public From visitFromClause(HqlParser.FromClauseContext ctx) {
        if (ctx == null) return null;
        List<TableWithJoins> tbls = new ArrayList<>();
        for (HqlParser.EntityWithJoinsContext join : ctx.entityWithJoins()) {
            tbls.add(visitEntityWithJoins(join));
        }
        return new From(tbls);
    }

    @Override
    public TableWithJoins visitEntityWithJoins(HqlParser.EntityWithJoinsContext ctx) {
        ATable root = (ATable) visit(ctx.fromRoot());
        List<AJoin> joins = new ArrayList<>();
        // TODO: visitJoin, visitCrossJoin, visitJpaCollectionJoin (deprecated)
        for (HqlParser.JoinContext join : ctx.join()) {
            joins.add((AJoin) visit(join));
        }
        return new TableWithJoins(root, joins);
    }

    @Override
    public ATable visitRootEntity(HqlParser.RootEntityContext ctx) {
        EntityName name = visitEntityName(ctx.entityName());
        String alias = visitVariable(ctx.variable());
        return new TableRoot(name, alias);
    }

    @Override
    public ATable visitRootSubquery(HqlParser.RootSubqueryContext ctx) {
        Select subquery = visitSubquery(ctx.subquery());
        String alias = visitVariable(ctx.variable());
        return new TableSubquery(subquery, alias);
    }

    @Override
    public EntityName visitEntityName(HqlParser.EntityNameContext ctx) {
        List<String> names = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            names.add(visitIdentifier((HqlParser.IdentifierContext) child));
        }
        return new EntityName(names);
    }

    @Override
    public String visitVariable(HqlParser.VariableContext ctx) {
        if (ctx == null) return null;
        ParseTree child = ctx.getChild(ctx.getChildCount() - 1);
        return (child instanceof HqlParser.IdentifierContext)
                ? visitIdentifier((HqlParser.IdentifierContext) child)
                : visitNakedIdentifier((HqlParser.NakedIdentifierContext) child);
    }

    @Override
    public Object visitCrossJoin(HqlParser.CrossJoinContext crossJoinContext) {
        return null;
    }

    @Override
    public Object visitJpaCollectionJoin(HqlParser.JpaCollectionJoinContext jpaCollectionJoinContext) {
        return null;
    }

    @Override
    public CommonJoin visitJoin(HqlParser.JoinContext ctx) {
        AExpression pred = visitJoinRestriction(ctx.joinRestriction());
        Path target = (Path) visit(ctx.joinTarget()); // TODO: visitJoinSubquery
        return resolveJoinType(ctx.joinType(), pred, target);
    }

    private CommonJoin resolveJoinType(HqlParser.JoinTypeContext ctx, AExpression pred, Path target) {
        if (ctx == null || ctx.getChildCount() == 0) return new CommonJoin(target, pred, CommonJoinType.INNER);
        int type = ((TerminalNode) ctx.getChild(0)).getSymbol().getType();
        if (type == HqlParser.FULL) {
            return new CommonJoin(target, pred, CommonJoinType.FULL);
        } else if (type == HqlParser.LEFT) {
            return new CommonJoin(target, pred, CommonJoinType.LEFT);
        } else if (type == HqlParser.RIGHT) {
            return new CommonJoin(target, pred, CommonJoinType.RIGHT);
        } else if (type == HqlParser.INNER) {
            return new CommonJoin(target, pred, CommonJoinType.INNER);
        } else {
            return new CommonJoin(target, pred, CommonJoinType.INNER);
        }
    }

    @Override
    public Object visitJoinType(HqlParser.JoinTypeContext joinTypeContext) {
        return null;
    }

    @Override
    public Path visitJoinPath(HqlParser.JoinPathContext ctx) {
        String alias = visitVariable(ctx.variable());
        Path path = visitPath(ctx.path());
        path.alias = alias;
        return path;
    }

    @Override
    public Object visitJoinSubquery(HqlParser.JoinSubqueryContext joinSubqueryContext) {
        return null;
    }

    @Override
    public AExpression visitJoinRestriction(HqlParser.JoinRestrictionContext ctx) {
        if (ctx == null) return null;
        return (AExpression) visit(ctx.predicate());
    }

    @Override
    public SelectFunction visitSelectClause(HqlParser.SelectClauseContext ctx) {
        if (ctx == null) return null;
        List<ASelection> selections = visitSelectionList(ctx.selectionList());
        return new SelectFunction(ctx.DISTINCT() != null, selections);
    }

    @Override
    public List<ASelection> visitSelectionList(HqlParser.SelectionListContext ctx) {
        List<ASelection> selections = new ArrayList<>();
        for (HqlParser.SelectionContext selectionCtx : ctx.selection()) {
            selections.add(visitSelection(selectionCtx));
        }
        return selections;
    }

    @Override
    public ASelection visitSelection(HqlParser.SelectionContext ctx) {
        String alias = visitVariable(ctx.variable());
        ASelection selection = visitSelectExpression(ctx.selectExpression());
        selection.alias = alias;
        return selection;
    }

    @Override
    public ASelection visitSelectExpression(HqlParser.SelectExpressionContext ctx) {
        if (ctx.instantiation() != null) {
            Object inst = visitInstantiation(ctx.instantiation());
            return new Instance(null, null);
        } else if (ctx.mapEntrySelection() != null) {
            Path path = visitPath(ctx.mapEntrySelection().path());
            return new Entry(path, null);
        } else if (ctx.expressionOrPredicate() != null) {
            AExpression expr = visitExpressionOrPredicate(ctx.expressionOrPredicate());
            return new Expression(expr, null);
        } else {
            return new JpaSelect(null);
        } // TODO:
    }

    @Override
    public Object visitMapEntrySelection(HqlParser.MapEntrySelectionContext mapEntrySelectionContext) {
        return null;
    }

    @Override
    public Object visitInstantiation(HqlParser.InstantiationContext instantiationContext) {
        return null;
    }

    @Override
    public Object visitInstantiationTarget(HqlParser.InstantiationTargetContext instantiationTargetContext) {
        return null;
    }

    @Override
    public Object visitInstantiationArguments(HqlParser.InstantiationArgumentsContext instantiationArgumentsContext) {
        return null;
    }

    @Override
    public Object visitInstantiationArgument(HqlParser.InstantiationArgumentContext instantiationArgumentContext) {
        return null;
    }

    @Override
    public Object visitInstantiationArgumentExpression(HqlParser.InstantiationArgumentExpressionContext instantiationArgumentExpressionContext) {
        return null;
    }

    @Override
    public Object visitJpaSelectObjectSyntax(HqlParser.JpaSelectObjectSyntaxContext jpaSelectObjectSyntaxContext) {
        return null;
    }

    @Override
    public SimplePath visitSimplePath(HqlParser.SimplePathContext ctx) {
        String root = visitIdentifier(ctx.identifier());
        List<String> cont = new ArrayList<>();
        for (HqlParser.SimplePathElementContext element : ctx.simplePathElement()) {
            cont.add(visitSimplePathElement(element));
        }
        return new SimplePath(root, cont);
    }

    @Override
    public String visitSimplePathElement(HqlParser.SimplePathElementContext ctx) {
        return visitIdentifier(ctx.identifier());
    }

    @Override
    public Path visitPath(HqlParser.PathContext ctx) {
        GeneralPath path = visitGeneralPathFragment(ctx.generalPathFragment());
        SimplePath cont = visitPathContinuation(ctx.pathContinuation());
        // ctx.syntacticDomainPath() TODO: ??
        return new Path(path, cont, null);
    }

    @Override
    public SimplePath visitPathContinuation(HqlParser.PathContinuationContext ctx) {
        if (ctx == null) return null;
        return visitSimplePath(ctx.simplePath());
    }
    @Override
    public Object visitSyntacticDomainPath(HqlParser.SyntacticDomainPathContext syntacticDomainPathContext) {
        return null;
    }

    @Override
    public GeneralPath visitGeneralPathFragment(HqlParser.GeneralPathFragmentContext ctx) {
        SimplePath simplePath = visitSimplePath(ctx.simplePath());
        Index indexCont = visitIndexedPathAccessFragment(ctx.indexedPathAccessFragment());
        return new GeneralPath(simplePath, indexCont);
    }

    @Override
    public Index visitIndexedPathAccessFragment(HqlParser.IndexedPathAccessFragmentContext ctx) {
        if (ctx == null) return null;
        AExpression ix = (AExpression) visit(ctx.expression());
        GeneralPath cont = ctx.generalPathFragment() != null ? visitGeneralPathFragment(ctx.generalPathFragment()) : null;
        return new Index(ix, cont);
    }

    @Override
    public Object visitTreatedNavigablePath(HqlParser.TreatedNavigablePathContext treatedNavigablePathContext) {
        return null;
    }

    @Override
    public Object visitCollectionValueNavigablePath(HqlParser.CollectionValueNavigablePathContext collectionValueNavigablePathContext) {
        return null;
    }

    @Override
    public Object visitMapKeyNavigablePath(HqlParser.MapKeyNavigablePathContext mapKeyNavigablePathContext) {
        return null;
    }

    @Override
    public GroupBy visitGroupByClause(HqlParser.GroupByClauseContext ctx) {
        if (ctx == null) return null;
        List<GroupBySpecification> groupSpecs = new ArrayList<>();
        for (HqlParser.GroupByExpressionContext expr : ctx.groupByExpression()) {
            groupSpecs.add(visitGroupByExpression(expr));
        }
        return new GroupBy(groupSpecs);
    }

    @Override
    public GroupBySpecification visitGroupByExpression(HqlParser.GroupByExpressionContext ctx) {
        ASpecification spec;
        if (ctx.identifier() != null) {
            spec = new ByIdentity(visitIdentifier(ctx.identifier()));
        } else if (ctx.expression() != null) {
            spec = new ByExpression((AExpression) visit(ctx.expression()));
        } else {
            spec = new ByPosition(intLiteral(ctx.INTEGER_LITERAL().getText()));
        }
        return new GroupBySpecification(spec);
    }

    @Override
    public Having visitHavingClause(HqlParser.HavingClauseContext ctx) {
        if (ctx == null) return null;
        AExpression expr = (AExpression) visit(ctx.predicate());
        if (expr != null) {
            return new Having(expr);
        }
        return null;
    }

    @Override
    public Order visitOrderByClause(HqlParser.OrderByClauseContext ctx) {
        List<SortSpecification> sorts = new ArrayList<>();
        for (HqlParser.SortSpecificationContext spec : ctx.sortSpecification()) {
            sorts.add(visitSortSpecification(spec));
        }
        return new Order(sorts, null, null);
    }

    @Override
    public Object visitOrderByFragment(HqlParser.OrderByFragmentContext orderByFragmentContext) {
        return null;
    }

    @Override
    public SortSpecification visitSortSpecification(HqlParser.SortSpecificationContext ctx) {
        Boolean dir = visitSortDirection(ctx.sortDirection());
        Boolean nulls = visitNullsPrecedence(ctx.nullsPrecedence());
        SortSpecification spec = visitSortExpression(ctx.sortExpression());
        spec.isAscending = dir != null ? dir : true;
        spec.isNullsLast = nulls != null ? nulls : true;
        return spec;
    }

    @Override
    public Boolean visitNullsPrecedence(HqlParser.NullsPrecedenceContext ctx) {
        if (ctx == null) return null;
        return ctx.LAST() != null;
    }

    @Override
    public SortSpecification visitSortExpression(HqlParser.SortExpressionContext ctx) {
        ASpecification spec;
        if (ctx.identifier() != null) {
            String ident = visitIdentifier(ctx.identifier());
            spec = new ByIdentity(ident);
        } else if (ctx.expression() != null) {
            AExpression expr = (AExpression) visit(ctx.expression());
            spec = new ByExpression(expr);
        } else {
            int pos = intLiteral(ctx.INTEGER_LITERAL().getText());
            spec = new ByPosition(pos);
        }
        return new SortSpecification(spec, true, true);
    }

    @Override
    public Boolean visitSortDirection(HqlParser.SortDirectionContext ctx) {
        if (ctx == null) return null;
        return ctx.ASC() != null;
    }
    @Override
    public Object visitCollateFunction(HqlParser.CollateFunctionContext collateFunctionContext) {
        return null;
    }

    @Override
    public Object visitCollation(HqlParser.CollationContext collationContext) {
        return null;
    }

    @Override
    public AParamOrInt visitLimitClause(HqlParser.LimitClauseContext ctx) {
        if (ctx == null) return null;
        return visitParameterOrIntegerLiteral(ctx.parameterOrIntegerLiteral());
    }

    @Override
    public AParamOrInt visitOffsetClause(HqlParser.OffsetClauseContext ctx) {
        if (ctx == null) return null;
        return visitParameterOrIntegerLiteral(ctx.parameterOrIntegerLiteral());
    }

    @Override
    public Object visitFetchClause(HqlParser.FetchClauseContext fetchClauseContext) {
        return null;
    }

    @Override
    public Object visitFetchCountOrPercent(HqlParser.FetchCountOrPercentContext fetchCountOrPercentContext) {
        return null;
    }

    @Override
    public AParamOrInt visitParameterOrIntegerLiteral(HqlParser.ParameterOrIntegerLiteralContext ctx) {
        if (ctx.parameter() != null) {
            AParameter param = (AParameter) visit(ctx.parameter());
            return new Param(param);
        } else {
            String text = ctx.INTEGER_LITERAL().getText();
            int num = intLiteral(text);
            return new Num(num);
        }
    }

    @Override
    public Object visitParameterOrNumberLiteral(HqlParser.ParameterOrNumberLiteralContext parameterOrNumberLiteralContext) {
        return null;
    }

    @Override
    public Where visitWhereClause(HqlParser.WhereClauseContext ctx) {
        if (ctx == null) return null;
        AExpression pred = (AExpression) visit(ctx.predicate());
        return new Where(pred);
    }

    @Override
    public AExpression visitIsDistinctFromPredicate(HqlParser.IsDistinctFromPredicateContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression(0));
        AExpression from = (AExpression) visit(ctx.expression(1));
        AExpression pred = new IsDistinct(expr, from);
        return ctx.NOT() == null ? pred : new Not(pred);
    }

    @Override
    public AExpression visitBetweenPredicate(HqlParser.BetweenPredicateContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression(0));
        AExpression left = (AExpression) visit(ctx.expression(1));
        AExpression right = (AExpression) visit(ctx.expression(2));
        AExpression pred = new Between(expr, left, right);
        return ctx.NOT() == null ? pred : new Not(pred);
    }

    @Override
    public AExpression visitExistsPredicate(HqlParser.ExistsPredicateContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression());
        return new Exist(expr);
    }

    @Override
    public AExpression visitAndPredicate(HqlParser.AndPredicateContext ctx) {
        AExpression left = (AExpression) visit(ctx.predicate(0));
        AExpression right = (AExpression) visit(ctx.predicate(1));
        return new And(left, right);
    }

    @Override
    public AExpression visitIsFalsePredicate(HqlParser.IsFalsePredicateContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression());
        AExpression pred = new IsTrue(expr);
        return ctx.NOT() == null ? new Not(pred) : pred;
    }

    @Override
    public AExpression visitGroupedPredicate(HqlParser.GroupedPredicateContext ctx) {
        return (AExpression) visit(ctx.predicate());
    }

    @Override
    public AExpression visitLikePredicate(HqlParser.LikePredicateContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression(0));
        AExpression pattern = (AExpression) visit(ctx.expression(1));
        AExpression escape = visitLikeEscape(ctx.likeEscape());
        AExpression pred = new Like(expr, pattern, escape, ctx.LIKE() != null);
        return ctx.NOT() == null ? pred : new Not(pred);
    }

    @Override
    public AExpression visitInPredicate(HqlParser.InPredicateContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression());
        AInValues inList = (AInValues) visit(ctx.inList());
        AExpression pred = new InFunction(expr, inList);
        return ctx.NOT() == null ? pred : new Not(pred);
    }

    @Override
    public AExpression visitComparisonPredicate(HqlParser.ComparisonPredicateContext ctx) {
        AExpression left = (AExpression) visit(ctx.expression(0));
        AExpression right = (AExpression) visit(ctx.expression(1));
        Operator comparator = visitComparisonOperator(ctx.comparisonOperator());
        return new Compare(left, right, comparator);
    }

    @Override
    public AExpression visitExistsCollectionPartPredicate(HqlParser.ExistsCollectionPartPredicateContext ctx) {
        ColQuantifierCtx quant = visitCollectionQuantifier(ctx.collectionQuantifier());
        SimplePath path = visitSimplePath(ctx.simplePath());
        return new ExistCollection(quant, path);
    }

    @Override
    public AExpression visitNegatedPredicate(HqlParser.NegatedPredicateContext ctx) {
        AExpression pred = (AExpression) visit(ctx.predicate());
        return new Not(pred);
    }

    @Override
    public AExpression visitBooleanExpressionPredicate(HqlParser.BooleanExpressionPredicateContext ctx) {
        return (AExpression) visit(ctx.expression());
    }

    @Override
    public AExpression visitOrPredicate(HqlParser.OrPredicateContext ctx) {
        AExpression left = (AExpression) visit(ctx.predicate(0));
        AExpression right = (AExpression) visit(ctx.predicate(1));
        return new Or(left, right);
    }

    @Override
    public AExpression visitMemberOfPredicate(HqlParser.MemberOfPredicateContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression());
        Path path = visitPath(ctx.path());
        AExpression pred = new Member(expr, path);
        return ctx.NOT() == null ? pred : new Not(pred);
    }

    @Override
    public AExpression visitIsEmptyPredicate(HqlParser.IsEmptyPredicateContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression());
        AExpression pred = new IsEmpty(expr);
        return ctx.NOT() == null ? pred : new Not(pred);
    }

    @Override
    public AExpression visitIsNullPredicate(HqlParser.IsNullPredicateContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression());
        AExpression pred = new IsNull(expr);
        return ctx.NOT() == null ? pred : new Not(pred);
    }

    @Override
    public AExpression visitIsTruePredicate(HqlParser.IsTruePredicateContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression());
        AExpression pred = new IsTrue(expr);
        return ctx.NOT() == null ? pred : new Not(pred);
    }

    @Override
    public Operator visitComparisonOperator(HqlParser.ComparisonOperatorContext ctx) {
        TerminalNode node = (TerminalNode) ctx.getChild(0);
        int type = node.getSymbol().getType();
        if (type == HqlLexer.EQUAL) {
            return Operator.EQUAL;
        } else if (type == HqlLexer.NOT_EQUAL) {
            return Operator.NOT_EQUAL;
        } else if (type == HqlLexer.GREATER) {
            return Operator.GREATER;
        } else if (type == HqlLexer.GREATER_EQUAL) {
            return Operator.GREATER_EQUAL;
        } else if (type == HqlLexer.LESS) {
            return Operator.LESS;
        } else {
            return Operator.LESS_EQUAL;
        }
    }

    @Override
    public Object visitPersistentCollectionReferenceInList(HqlParser.PersistentCollectionReferenceInListContext persistentCollectionReferenceInListContext) {
        return null;
    }

    @Override
    public Object visitExplicitTupleInList(HqlParser.ExplicitTupleInListContext explicitTupleInListContext) {
        return null;
    }

    @Override
    public ListIn visitSubqueryInList(HqlParser.SubqueryInListContext ctx) {
        Select subquery = visitSubquery(ctx.subquery());
        return new ListIn(subquery);
    }

    @Override
    public ParameterIn visitParamInList(HqlParser.ParamInListContext ctx) {
        AParameter param = (AParameter) visit(ctx.parameter());
        return new ParameterIn(param);
    }

    @Override
    public AExpression visitLikeEscape(HqlParser.LikeEscapeContext ctx) {
        if (ctx == null) return null;
        ParseTree node = ctx.getChild(0);
        if (!(node instanceof TerminalNode)) {
            return (AExpression) visit(node);
        }
        return visitString((TerminalNode) node);
    }

    @Override
    public AExpression visitAdditionExpression(HqlParser.AdditionExpressionContext ctx) {
        AExpression left = (AExpression) visit(ctx.expression(0));
        AExpression right = (AExpression) visit(ctx.expression(1));
        FOperator op = visitAdditiveOperator(ctx.additiveOperator());
        return new BinOperator(left, right, op);
    }

    @Override
    public Object visitFromDurationExpression(HqlParser.FromDurationExpressionContext fromDurationExpressionContext) {
        return null;
    }

    @Override
    public AExpression visitBarePrimaryExpression(HqlParser.BarePrimaryExpressionContext ctx) {
        return (AExpression) visitChildren(ctx);
    }

    @Override
    public AExpression visitTupleExpression(HqlParser.TupleExpressionContext ctx) {
        List<AExpression> elems = new ArrayList<>();
        for (HqlParser.ExpressionOrPredicateContext exprCtx : ctx.expressionOrPredicate()) {
            elems.add(visitExpressionOrPredicate(exprCtx));
        }
        return new Tuple(elems);
    }

    @Override
    public AExpression visitUnaryExpression(HqlParser.UnaryExpressionContext ctx) {
        AExpression expr = (AExpression) visit(ctx.expression());
        return visitSignOperator(ctx.signOperator()) ? new Minus(expr) : expr;
    }

    @Override
    public AExpression visitGroupedExpression(HqlParser.GroupedExpressionContext ctx) {
        return (AExpression) visitChildren(ctx);
    }

    @Override
    public AExpression visitConcatenationExpression(HqlParser.ConcatenationExpressionContext ctx) {
        AExpression left = (AExpression) visit(ctx.expression(0));
        AExpression right = (AExpression) visit(ctx.expression(1));
        FOperator op = FOperator.Concat;
        return new BinOperator(left, right, op);
    }

    @Override
    public AExpression visitMultiplicationExpression(HqlParser.MultiplicationExpressionContext ctx) {
        AExpression left = (AExpression) visit(ctx.expression(0));
        AExpression right = (AExpression) visit(ctx.expression(1));
        FOperator op = visitMultiplicativeOperator(ctx.multiplicativeOperator());
        return new BinOperator(left, right, op);
    }

    @Override
    public Object visitToDurationExpression(HqlParser.ToDurationExpressionContext toDurationExpressionContext) {
        return null;
    }

    @Override
    public AExpression visitSubqueryExpression(HqlParser.SubqueryExpressionContext ctx) {
        Select query = visitSubquery(ctx.subquery());
        return new Subquery(query);
    }

    @Override
    public AExpression visitUnaryNumericLiteralExpression(HqlParser.UnaryNumericLiteralExpressionContext ctx) {
        AExpression num = visitNumericLiteral(ctx.numericLiteral());
        return visitSignOperator(ctx.signOperator()) ? new Minus(num) : num;
    }

    @Override
    public AExpression visitCaseExpression(HqlParser.CaseExpressionContext ctx) {
        return (AExpression) visitChildren(ctx);
    }

    @Override
    public AExpression visitLiteralExpression(HqlParser.LiteralExpressionContext ctx) {
        return (AExpression) visitChildren(ctx);
    }

    @Override
    public AExpression visitParameterExpression(HqlParser.ParameterExpressionContext ctx) {
        AParameter param = (AParameter) visit(ctx.parameter());
        return new Parameter(param);
    }

    @Override
    public AExpression visitEntityTypeExpression(HqlParser.EntityTypeExpressionContext ctx) {
        return visitEntityTypeReference(ctx.entityTypeReference());
    }

    @Override
    public Object visitEntityIdExpression(HqlParser.EntityIdExpressionContext entityIdExpressionContext) {
        return null;
    }

    @Override
    public Object visitEntityVersionExpression(HqlParser.EntityVersionExpressionContext entityVersionExpressionContext) {
        return null;
    }

    @Override
    public Object visitEntityNaturalIdExpression(HqlParser.EntityNaturalIdExpressionContext entityNaturalIdExpressionContext) {
        return null;
    }

    @Override
    public Object visitToOneFkExpression(HqlParser.ToOneFkExpressionContext toOneFkExpressionContext) {
        return null;
    }

    @Override
    public AExpression visitSyntacticPathExpression(HqlParser.SyntacticPathExpressionContext syntacticPathExpressionContext) {
        return new SyntacticPath();
    }

    @Override
    public AExpression visitFunctionExpression(HqlParser.FunctionExpressionContext ctx) {
        return visitFunction(ctx.function());
    }

    @Override
    public AExpression visitGeneralPathExpression(HqlParser.GeneralPathExpressionContext ctx) {
        GeneralPath path = visitGeneralPathFragment(ctx.generalPathFragment());
        return new ExprPath(path);
    }

    @Override
    public AExpression visitExpressionOrPredicate(HqlParser.ExpressionOrPredicateContext ctx) {
        if (ctx.expression() != null) {
            return (AExpression) visit(ctx.expression());
        }
        return (AExpression) visit(ctx.predicate());
    }

    @Override
    public ColQuantifierCtx visitCollectionQuantifier(HqlParser.CollectionQuantifierContext collectionQuantifierContext) {
        return null;
    }

    @Override
    public Object visitElementValueQuantifier(HqlParser.ElementValueQuantifierContext elementValueQuantifierContext) {
        return null;
    }

    @Override
    public Object visitIndexKeyQuantifier(HqlParser.IndexKeyQuantifierContext indexKeyQuantifierContext) {
        return null;
    }

    @Override
    public Object visitElementsValuesQuantifier(HqlParser.ElementsValuesQuantifierContext elementsValuesQuantifierContext) {
        return null;
    }

    @Override
    public Object visitIndicesKeysQuantifier(HqlParser.IndicesKeysQuantifierContext indicesKeysQuantifierContext) {
        return null;
    }

    @Override
    public FOperator visitMultiplicativeOperator(HqlParser.MultiplicativeOperatorContext ctx) {
        TerminalNode node = (TerminalNode) ctx.getChild(0);
        int type = node.getSymbol().getType();
        if (type == HqlParser.SLASH) {
            return FOperator.Slash;
        } else if (type == HqlParser.PERCENT_OP) {
            return FOperator.Percent;
        } else {
            return FOperator.Asterisk;
        }
    }

    @Override
    public FOperator visitAdditiveOperator(HqlParser.AdditiveOperatorContext ctx) {
        TerminalNode node = (TerminalNode) ctx.getChild(0);
        return node.getSymbol().getType() == HqlParser.PLUS
                ? FOperator.Plus
                : FOperator.Minus;
    }

    @Override
    public Boolean visitSignOperator(HqlParser.SignOperatorContext ctx) {
        return ctx.MINUS() != null;
    }

    @Override
    public AExpression visitEntityTypeReference(HqlParser.EntityTypeReferenceContext ctx) {
        if (ctx.path() != null) {
            Path path = visitPath(ctx.path());
            return new TypeOfPath(path);
        } else {
            Parameter param = (Parameter) visit(ctx.parameter());
            return new TypeOfParameter(param);
        }
    }

    @Override
    public AExpression visitEntityIdReference(HqlParser.EntityIdReferenceContext ctx) {
        Path path = visitPath(ctx.path());
        SimplePath cont = visitPathContinuation(ctx.pathContinuation());
        return new Id(path, cont);
    }

    @Override
    public AExpression visitEntityVersionReference(HqlParser.EntityVersionReferenceContext ctx) {
        Path path = visitPath(ctx.path());
        return new Version(path);
    }

    @Override
    public AExpression visitEntityNaturalIdReference(HqlParser.EntityNaturalIdReferenceContext ctx) {
        Path path = visitPath(ctx.path());
        SimplePath cont = visitPathContinuation(ctx.pathContinuation());
        return new NaturalId(path, cont);
    }

    @Override
    public Object visitToOneFkReference(HqlParser.ToOneFkReferenceContext toOneFkReferenceContext) {
        return null;
    }

    @Override
    public AExpression visitCaseList(HqlParser.CaseListContext ctx) {
        if (ctx.simpleCaseList() != null) {
            return visitSimpleCaseList(ctx.simpleCaseList());
        }
        return visitSearchedCaseList(ctx.searchedCaseList());
    }

    @Override
    public AExpression visitSimpleCaseList(HqlParser.SimpleCaseListContext ctx) {
        AExpression caseValue = visitExpressionOrPredicate(ctx.expressionOrPredicate());
        List<BranchCtx> branches = new ArrayList<>();
        for (HqlParser.SimpleCaseWhenContext whenCtx : ctx.simpleCaseWhen()) {
            branches.add(visitSimpleCaseWhen(whenCtx));
        }
        AExpression elseValue = visitCaseOtherwise(ctx.caseOtherwise());
        return new SimpleCaseList(caseValue, branches, elseValue);
    }

    @Override
    public BranchCtx visitSimpleCaseWhen(HqlParser.SimpleCaseWhenContext ctx) {
        AExpression pattern = (AExpression) visit(ctx.expression());
        AExpression value = visitExpressionOrPredicate(ctx.expressionOrPredicate());
        return new BranchCtx(pattern, value);
    }

    @Override
    public AExpression visitCaseOtherwise(HqlParser.CaseOtherwiseContext ctx) {
        return visitExpressionOrPredicate(ctx.expressionOrPredicate());
    }

    @Override
    public CaseList visitSearchedCaseList(HqlParser.SearchedCaseListContext ctx) {
        List<BranchCtx> branches = new ArrayList<>();
        for (HqlParser.SearchedCaseWhenContext whenCtx : ctx.searchedCaseWhen()) {
            branches.add(visitSearchedCaseWhen(whenCtx));
        }
        AExpression elseValue = visitCaseOtherwise(ctx.caseOtherwise());
        return new CaseList(branches, elseValue);
    }

    @Override
    public BranchCtx visitSearchedCaseWhen(HqlParser.SearchedCaseWhenContext ctx) {
        AExpression pattern = (AExpression) visit(ctx.predicate());
        AExpression value = visitExpressionOrPredicate(ctx.expressionOrPredicate());
        return new BranchCtx(pattern, value);
    }

    @Override
    public AExpression visitLiteral(HqlParser.LiteralContext ctx) {
        ParseTree node = ctx.getChild(0);
        if (!(node instanceof TerminalNode)) {
            return (AExpression) visit(node);
        }
        return visitString((TerminalNode) node);
    }

    private AExpression visitString(TerminalNode node) {
        int type = node.getSymbol().getType();
        if (type == HqlParser.STRING_LITERAL) {
            return new LString(unquoteStringLiteral(node.getText()));
        } else if (type == HqlParser.JAVA_STRING_LITERAL) {
            return new LString(unquoteJavaStringLiteral(node.getText()));
        } else {
            return new LNull();
        }
    }

    @Override
    public AExpression visitBooleanLiteral(HqlParser.BooleanLiteralContext ctx) {
        return new LBool(ctx.TRUE() != null);
    }

    public int intLiteral(String text) {
        return Integer.parseInt(text.replace("_", ""));
    }

    public long longLiteral(String text) {
        return Long.parseLong(text.substring(0, text.length() - 1).replace("_", ""));
    }

    public String bigIntLiteral(String text) {
        return text.substring(0, text.length() - 2).replace("_", "");
    }

    public float floatLiteral(String text) {
        return Float.parseFloat(text.substring(0, text.length() - 1).replace("_", ""));
    }

    public double doubleLiteral(String text) {
        return Double.parseDouble(text.substring(0, text.length() - 1).replace("_", ""));
    }

    public String bigDecimalLiteral(String text) {
        return text.substring(0, text.length() - 2).replace("_", "");
    }

    public long hexLongLiteral(String text) {
        return Long.parseLong(text.substring(2, text.length() - 1).replace("_", ""), 16);
    }

    public int hexIntLiteral(String text) {
        return Integer.parseInt(text.substring(2).replace("_", ""), 16);
    }

    @Override
    public AExpression visitNumericLiteral(HqlParser.NumericLiteralContext ctx) {
        TerminalNode node = (TerminalNode) ctx.getChild(0);
        String text = node.getText();
        int type = node.getSymbol().getType();
        switch (type) {
            case HqlParser.INTEGER_LITERAL:
                return new LInt(intLiteral(text));
            case HqlParser.LONG_LITERAL:
                return new LLong(longLiteral(text));
            case HqlParser.BIG_INTEGER_LITERAL:
                return new LBigInt(bigIntLiteral(text));
            case HqlParser.FLOAT_LITERAL:
                return new LFloat(floatLiteral(text));
            case HqlParser.DOUBLE_LITERAL:
                return new LDouble(doubleLiteral(text));
            case HqlParser.BIG_DECIMAL_LITERAL:
                return new LBigDecimal(bigDecimalLiteral(text));
            default:
                if (text.endsWith("l")) {
                    return new LLong(hexLongLiteral(text));
                } else {
                    return new LInt(hexIntLiteral(text));
                }
        }
    }

    @Override
    public AExpression visitBinaryLiteral(HqlParser.BinaryLiteralContext ctx) {
        TerminalNode node = (TerminalNode) ctx.getChild(0);
        String nodeText = node.getText();
        String text;

        if (node.getSymbol().getType() == HqlParser.BINARY_LITERAL) {
            text = nodeText.substring(2, nodeText.length() - 1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (ParseTree child : ctx.children) {
                sb.append(child.getText().substring(2, 4));
            }
            text = sb.toString();
        }

        byte[] arr = PrimitiveByteArrayJavaType.INSTANCE.fromString(text);
        return new LBinary(arr);
    }
    @Override
    public Object visitTemporalLiteral(HqlParser.TemporalLiteralContext temporalLiteralContext) {
        return null;
    }

    @Override
    public Object visitDateTimeLiteral(HqlParser.DateTimeLiteralContext dateTimeLiteralContext) {
        return null;
    }

    @Override
    public Object visitLocalDateTimeLiteral(HqlParser.LocalDateTimeLiteralContext localDateTimeLiteralContext) {
        return null;
    }

    @Override
    public Object visitZonedDateTimeLiteral(HqlParser.ZonedDateTimeLiteralContext zonedDateTimeLiteralContext) {
        return null;
    }

    @Override
    public Object visitOffsetDateTimeLiteral(HqlParser.OffsetDateTimeLiteralContext offsetDateTimeLiteralContext) {
        return null;
    }

    @Override
    public Object visitDateLiteral(HqlParser.DateLiteralContext dateLiteralContext) {
        return null;
    }

    @Override
    public Object visitTimeLiteral(HqlParser.TimeLiteralContext timeLiteralContext) {
        return null;
    }

    @Override
    public Object visitDateTime(HqlParser.DateTimeContext dateTimeContext) {
        return null;
    }

    @Override
    public Object visitLocalDateTime(HqlParser.LocalDateTimeContext localDateTimeContext) {
        return null;
    }

    @Override
    public Object visitZonedDateTime(HqlParser.ZonedDateTimeContext zonedDateTimeContext) {
        return null;
    }

    @Override
    public Object visitOffsetDateTime(HqlParser.OffsetDateTimeContext offsetDateTimeContext) {
        return null;
    }

    @Override
    public Object visitOffsetDateTimeWithMinutes(HqlParser.OffsetDateTimeWithMinutesContext offsetDateTimeWithMinutesContext) {
        return null;
    }

    @Override
    public Object visitDate(HqlParser.DateContext dateContext) {
        return null;
    }

    @Override
    public Object visitTime(HqlParser.TimeContext timeContext) {
        return null;
    }

    @Override
    public Object visitOffset(HqlParser.OffsetContext offsetContext) {
        return null;
    }

    @Override
    public Object visitOffsetWithMinutes(HqlParser.OffsetWithMinutesContext offsetWithMinutesContext) {
        return null;
    }

    @Override
    public Object visitYear(HqlParser.YearContext yearContext) {
        return null;
    }

    @Override
    public Object visitMonth(HqlParser.MonthContext monthContext) {
        return null;
    }

    @Override
    public Object visitDay(HqlParser.DayContext dayContext) {
        return null;
    }

    @Override
    public Object visitHour(HqlParser.HourContext hourContext) {
        return null;
    }

    @Override
    public Object visitMinute(HqlParser.MinuteContext minuteContext) {
        return null;
    }

    @Override
    public Object visitSecond(HqlParser.SecondContext secondContext) {
        return null;
    }

    @Override
    public Object visitZoneId(HqlParser.ZoneIdContext zoneIdContext) {
        return null;
    }

    @Override
    public Object visitJdbcTimestampLiteral(HqlParser.JdbcTimestampLiteralContext jdbcTimestampLiteralContext) {
        return null;
    }

    @Override
    public Object visitJdbcDateLiteral(HqlParser.JdbcDateLiteralContext jdbcDateLiteralContext) {
        return null;
    }

    @Override
    public Object visitJdbcTimeLiteral(HqlParser.JdbcTimeLiteralContext jdbcTimeLiteralContext) {
        return null;
    }

    @Override
    public Object visitGenericTemporalLiteralText(HqlParser.GenericTemporalLiteralTextContext genericTemporalLiteralTextContext) {
        return null;
    }

    @Override
    public Object visitGeneralizedLiteral(HqlParser.GeneralizedLiteralContext generalizedLiteralContext) {
        return null;
    }

    @Override
    public Object visitGeneralizedLiteralType(HqlParser.GeneralizedLiteralTypeContext generalizedLiteralTypeContext) {
        return null;
    }

    @Override
    public Object visitGeneralizedLiteralText(HqlParser.GeneralizedLiteralTextContext generalizedLiteralTextContext) {
        return null;
    }

    @Override
    public AParameter visitNamedParameter(HqlParser.NamedParameterContext ctx) {
        String ident = visitIdentifier(ctx.identifier());
        return new Colon(ident);
    }

    @Override
    public AParameter visitPositionalParameter(HqlParser.PositionalParameterContext ctx) {
        int pos = intLiteral(ctx.INTEGER_LITERAL().getText()); // just '?' is deprecated
        return new Positional(pos);
    }

    @Override
    public SqlFunction visitFunction(HqlParser.FunctionContext ctx) {
        return (SqlFunction) visit(ctx.getChild(0));
    }

    @Override
    public Object visitJpaNonstandardFunction(HqlParser.JpaNonstandardFunctionContext jpaNonstandardFunctionContext) {
        return null;
    }

    @Override
    public Object visitJpaNonstandardFunctionName(HqlParser.JpaNonstandardFunctionNameContext jpaNonstandardFunctionNameContext) {
        return null;
    }

    @Override
    public Object visitColumnFunction(HqlParser.ColumnFunctionContext columnFunctionContext) {
        return null;
    }

    @Override
    public SqlFunction visitGenericFunction(HqlParser.GenericFunctionContext ctx) {
        String functionName = visitSimplePath(ctx.genericFunctionName().simplePath())
                .root
                .toUpperCase();
        FunctionType func = FunctionType.valueOf(functionName);
        List<AExpression> args = ctx.ASTERISK() != null
                ? Collections.emptyList()
                : visitGenericFunctionArguments(ctx.genericFunctionArguments());
        return new SqlFunction(func, args);
    }

    @Override
    // unused
    public Object visitGenericFunctionName(HqlParser.GenericFunctionNameContext genericFunctionNameContext) {
        return null;
    }

    @Override
    public List<AExpression> visitGenericFunctionArguments(HqlParser.GenericFunctionArgumentsContext ctx) {
        List<AExpression> arguments = new ArrayList<>();
        for (HqlParser.ExpressionOrPredicateContext exprCtx : ctx.expressionOrPredicate()) {
            arguments.add(visitExpressionOrPredicate(exprCtx));
        }
        return arguments;
    }

    @Override
    public Object visitCollectionSizeFunction(HqlParser.CollectionSizeFunctionContext collectionSizeFunctionContext) {
        return null;
    }

    @Override
    public Object visitElementAggregateFunction(HqlParser.ElementAggregateFunctionContext elementAggregateFunctionContext) {
        return null;
    }

    @Override
    public Object visitIndexAggregateFunction(HqlParser.IndexAggregateFunctionContext indexAggregateFunctionContext) {
        return null;
    }

    @Override
    public Object visitCollectionFunctionMisuse(HqlParser.CollectionFunctionMisuseContext collectionFunctionMisuseContext) {
        return null;
    }

    @Override
    public SqlFunction visitAggregateFunction(HqlParser.AggregateFunctionContext ctx) {
        if (ctx.everyFunction() != null) {
            return visitEveryFunction(ctx.everyFunction());
        }
        if (ctx.anyFunction() != null) {
            return visitAnyFunction(ctx.anyFunction());
        }
        return visitListaggFunction(ctx.listaggFunction());
    }

    @Override
    public SqlFunction visitEveryFunction(HqlParser.EveryFunctionContext ctx) {
        // TODO: predicate may be null
        AExpression predicate = (AExpression) visit(ctx.predicate());
        List<AExpression> args = Collections.singletonList(predicate);
        return new SqlFunction(FunctionType.EVERY, args);
    }

    @Override
    public SqlFunction visitAnyFunction(HqlParser.AnyFunctionContext ctx) {
        // TODO: predicate may be null
        AExpression predicate = (AExpression) visit(ctx.predicate());
        List<AExpression> args = Collections.singletonList(predicate);
        return new SqlFunction(FunctionType.ANY, args);
    }

    @Override
    // not used
    public Object visitEveryAllQuantifier(HqlParser.EveryAllQuantifierContext everyAllQuantifierContext) {
        return null;
    }

    @Override
    // not used
    public Object visitAnySomeQuantifier(HqlParser.AnySomeQuantifierContext anySomeQuantifierContext) {
        return null;
    }

    @Override
    public SqlFunction visitListaggFunction(HqlParser.ListaggFunctionContext listaggFunctionContext) {
        return null;
    }

    @Override
    public Object visitOnOverflowClause(HqlParser.OnOverflowClauseContext onOverflowClauseContext) {
        return null;
    }

    @Override
    public Object visitWithinGroupClause(HqlParser.WithinGroupClauseContext withinGroupClauseContext) {
        return null;
    }

    @Override
    public Object visitFilterClause(HqlParser.FilterClauseContext filterClauseContext) {
        return null;
    }

    @Override
    public Object visitNullsClause(HqlParser.NullsClauseContext nullsClauseContext) {
        return null;
    }

    @Override
    public Object visitNthSideClause(HqlParser.NthSideClauseContext nthSideClauseContext) {
        return null;
    }

    @Override
    public Object visitOverClause(HqlParser.OverClauseContext overClauseContext) {
        return null;
    }

    @Override
    public Object visitPartitionClause(HqlParser.PartitionClauseContext partitionClauseContext) {
        return null;
    }

    @Override
    public Object visitFrameClause(HqlParser.FrameClauseContext frameClauseContext) {
        return null;
    }

    @Override
    public Object visitFrameStart(HqlParser.FrameStartContext frameStartContext) {
        return null;
    }

    @Override
    public Object visitFrameEnd(HqlParser.FrameEndContext frameEndContext) {
        return null;
    }

    @Override
    public Object visitFrameExclusion(HqlParser.FrameExclusionContext frameExclusionContext) {
        return null;
    }

    @Override
    public Object visitStandardFunction(HqlParser.StandardFunctionContext standardFunctionContext) {
        return null;
    }

    @Override
    public Object visitCastFunction(HqlParser.CastFunctionContext castFunctionContext) {
        return null;
    }

    @Override
    public Object visitCastTarget(HqlParser.CastTargetContext castTargetContext) {
        return null;
    }

    @Override
    public Object visitCastTargetType(HqlParser.CastTargetTypeContext castTargetTypeContext) {
        return null;
    }

    @Override
    public Object visitSubstringFunction(HqlParser.SubstringFunctionContext substringFunctionContext) {
        return null;
    }

    @Override
    public Object visitSubstringFunctionStartArgument(HqlParser.SubstringFunctionStartArgumentContext substringFunctionStartArgumentContext) {
        return null;
    }

    @Override
    public Object visitSubstringFunctionLengthArgument(HqlParser.SubstringFunctionLengthArgumentContext substringFunctionLengthArgumentContext) {
        return null;
    }

    @Override
    public Object visitTrimFunction(HqlParser.TrimFunctionContext trimFunctionContext) {
        return null;
    }

    @Override
    public Object visitTrimSpecification(HqlParser.TrimSpecificationContext trimSpecificationContext) {
        return null;
    }

    @Override
    public Object visitTrimCharacter(HqlParser.TrimCharacterContext trimCharacterContext) {
        return null;
    }

    @Override
    public Object visitPadFunction(HqlParser.PadFunctionContext padFunctionContext) {
        return null;
    }

    @Override
    public Object visitPadSpecification(HqlParser.PadSpecificationContext padSpecificationContext) {
        return null;
    }

    @Override
    public Object visitPadCharacter(HqlParser.PadCharacterContext padCharacterContext) {
        return null;
    }

    @Override
    public Object visitPadLength(HqlParser.PadLengthContext padLengthContext) {
        return null;
    }

    @Override
    public Object visitOverlayFunction(HqlParser.OverlayFunctionContext overlayFunctionContext) {
        return null;
    }

    @Override
    public Object visitOverlayFunctionStringArgument(HqlParser.OverlayFunctionStringArgumentContext overlayFunctionStringArgumentContext) {
        return null;
    }

    @Override
    public Object visitOverlayFunctionReplacementArgument(HqlParser.OverlayFunctionReplacementArgumentContext overlayFunctionReplacementArgumentContext) {
        return null;
    }

    @Override
    public Object visitOverlayFunctionStartArgument(HqlParser.OverlayFunctionStartArgumentContext overlayFunctionStartArgumentContext) {
        return null;
    }

    @Override
    public Object visitOverlayFunctionLengthArgument(HqlParser.OverlayFunctionLengthArgumentContext overlayFunctionLengthArgumentContext) {
        return null;
    }

    @Override
    public Object visitCurrentDateFunction(HqlParser.CurrentDateFunctionContext currentDateFunctionContext) {
        return null;
    }

    @Override
    public Object visitCurrentTimeFunction(HqlParser.CurrentTimeFunctionContext currentTimeFunctionContext) {
        return null;
    }

    @Override
    public Object visitCurrentTimestampFunction(HqlParser.CurrentTimestampFunctionContext currentTimestampFunctionContext) {
        return null;
    }

    @Override
    public Object visitInstantFunction(HqlParser.InstantFunctionContext instantFunctionContext) {
        return null;
    }

    @Override
    public Object visitLocalDateTimeFunction(HqlParser.LocalDateTimeFunctionContext localDateTimeFunctionContext) {
        return null;
    }

    @Override
    public Object visitOffsetDateTimeFunction(HqlParser.OffsetDateTimeFunctionContext offsetDateTimeFunctionContext) {
        return null;
    }

    @Override
    public Object visitLocalDateFunction(HqlParser.LocalDateFunctionContext localDateFunctionContext) {
        return null;
    }

    @Override
    public Object visitLocalTimeFunction(HqlParser.LocalTimeFunctionContext localTimeFunctionContext) {
        return null;
    }

    @Override
    public Object visitFormatFunction(HqlParser.FormatFunctionContext formatFunctionContext) {
        return null;
    }

    @Override
    public Object visitFormat(HqlParser.FormatContext formatContext) {
        return null;
    }

    @Override
    public Object visitExtractFunction(HqlParser.ExtractFunctionContext extractFunctionContext) {
        return null;
    }

    @Override
    public Object visitTruncFunction(HqlParser.TruncFunctionContext truncFunctionContext) {
        return null;
    }

    @Override
    public Object visitExtractField(HqlParser.ExtractFieldContext extractFieldContext) {
        return null;
    }

    @Override
    public Object visitDatetimeField(HqlParser.DatetimeFieldContext datetimeFieldContext) {
        return null;
    }

    @Override
    public Object visitDayField(HqlParser.DayFieldContext dayFieldContext) {
        return null;
    }

    @Override
    public Object visitWeekField(HqlParser.WeekFieldContext weekFieldContext) {
        return null;
    }

    @Override
    public Object visitTimeZoneField(HqlParser.TimeZoneFieldContext timeZoneFieldContext) {
        return null;
    }

    @Override
    public Object visitDateOrTimeField(HqlParser.DateOrTimeFieldContext dateOrTimeFieldContext) {
        return null;
    }

    @Override
    public Object visitPositionFunction(HqlParser.PositionFunctionContext positionFunctionContext) {
        return null;
    }

    @Override
    public Object visitPositionFunctionPatternArgument(HqlParser.PositionFunctionPatternArgumentContext positionFunctionPatternArgumentContext) {
        return null;
    }

    @Override
    public Object visitPositionFunctionStringArgument(HqlParser.PositionFunctionStringArgumentContext positionFunctionStringArgumentContext) {
        return null;
    }

    @Override
    public Object visitCube(HqlParser.CubeContext cubeContext) {
        return null;
    }

    @Override
    public Object visitRollup(HqlParser.RollupContext rollupContext) {
        return null;
    }

    @Override
    public String visitNakedIdentifier(HqlParser.NakedIdentifierContext ctx) {
        TerminalNode child = (TerminalNode) ctx.getChild(0);
        if (child.getSymbol().getType() == HqlParser.QUOTED_IDENTIFIER) {
            return QuotingHelper.unquoteIdentifier(child.getText());
        }
        return child.getText();
    }

    @Override
    public String visitIdentifier(HqlParser.IdentifierContext ctx) {
        ParseTree child = ctx.getChild(0);
        if (child instanceof TerminalNode) {
            return child.getText();
        }
        return visitNakedIdentifier((HqlParser.NakedIdentifierContext) child);
    }
}
